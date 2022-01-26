package com.cloud.platform.service.device.run.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceArchives;
import com.cloud.platform.entity.device.run.DeviceBatch;
import com.cloud.platform.entity.device.run.DeviceBatchInfo;
import com.cloud.platform.entity.device.run.DeviceRecall;
import com.cloud.platform.mapper.device.run.DeviceBatchInfoMapper;
import com.cloud.platform.req.DeviceBatchInfoREQ;
import com.cloud.platform.req.MessageHeadREQ;
import com.cloud.platform.service.IMqttHttpPort;
import com.cloud.platform.service.TmidService;
import com.cloud.platform.service.device.IDeviceArchivesService;
import com.cloud.platform.service.device.run.IDeviceBatchInfoService;
import com.cloud.platform.service.device.run.IDeviceBatchService;
import com.cloud.platform.service.device.run.IDeviceRecallService;
import com.cloud.platform.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 设备批次信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Slf4j
@Service
public class DeviceBatchInfoServiceImpl
        extends ServiceImpl<DeviceBatchInfoMapper, DeviceBatchInfo> implements IDeviceBatchInfoService {
  @Resource
  private IDeviceRecallService recallService;
  @Resource
  private IDeviceArchivesService archivesService;

  @Resource
  private TmidService tmidService;
  @Resource
  private IDeviceBatchService batchService;
  @Resource
  private IMqttHttpPort iMqttHttpPort;

  @Override
  public ResultVo search(DeviceBatchInfoREQ req) {
    QueryWrapper wrapper = new QueryWrapper();
    if (!ObjectUtils.isEmpty(req.getDbiName())) {
      wrapper.like("dbi_name", req.getDbiName());
    }
    if (!ObjectUtils.isEmpty(req.getStartTime())) {
      wrapper.between("dbi_createTime", req.getStartTime(), req.getEndTime());
    }
    wrapper.orderByDesc("dbi_createTime");

    IPage<DeviceBatchInfo> batchInfoIPage = baseMapper.selectPage(req.getPage(), wrapper);

    return ResultVo.ok(batchInfoIPage.getRecords(), batchInfoIPage.getTotal());
  }

  @Override
  public Result recallList() {
    QueryWrapper wrapper = new QueryWrapper();
    wrapper.orderByDesc("df_create");
    List<DeviceRecall> list = recallService.list(wrapper);
    return Result.ok(list);
  }

  @Override
  @Transactional
  public Result saveBatch(DeviceBatchInfoREQ req) {
    DeviceBatchInfo batchInfo = new DeviceBatchInfo();
    List<String> daIds = req.getDaIds();
    String daIdstr = daIds.stream().map(s -> "\'" + s + "\'").collect(Collectors.joining(", "));
    List<String> recalls = req.getRecalls();
    String name = "ZH" + TimeUtil.getDateKey();
    batchInfo.setDbiName(name);
    batchInfo.setDbiRecalltype(recalls.toString());
    batchInfo.setDbiNum(daIds.size());
    batchInfo.setDbiCreatetime(new Date());
    List<DeviceRecall> recalls1 = recallService.getList(recalls);
    QueryWrapper wrapper = new QueryWrapper();
    wrapper.inSql("da_id", daIdstr);
    List<DeviceArchives> arclist = archivesService.list(wrapper);
    //通过召回的项分别分发命令
    recalls1.forEach(n -> {
      for (DeviceArchives archives : arclist) {
        Integer mid = tmidService.getMid();
        MessageHeadREQ messageLog = new MessageHeadREQ();
        DeviceBatch batch = new DeviceBatch();
        batch.setDbArcid(archives.getDaId());
        batch.setDbMid(mid);
        batch.setDbBatchid(name);
        batch.setDbType(Integer.parseInt(n.getDrId()));
        batch.setDbCreatetime(new Date());
        messageLog.setMid(mid);
        messageLog.setDeviceId(archives.getDeviceId());
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        messageLog.setTimestamp(sdf.format(new Date()));
        messageLog.setType(n.getDfEvent());
        messageLog.setParam(null);
        messageLog.setMsg(null);
        log.info("元素排序：{}", JSONObject.toJSONString(messageLog));
        Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/" + archives.getDeviceId() + n.getDfDirect());
        if (aBoolean) {
          batchService.save(batch);
        }
      }
    });
    baseMapper.insert(batchInfo);
    return Result.ok();
  }


}
