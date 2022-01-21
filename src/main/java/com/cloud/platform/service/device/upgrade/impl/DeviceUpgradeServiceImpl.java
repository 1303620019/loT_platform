package com.cloud.platform.service.device.upgrade.impl;



import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.cloud.platform.entity.device.DeviceLinkFileSign;
import com.cloud.platform.entity.device.DeviceLinkInfo;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
import com.cloud.platform.entity.device.market.DevicePatch;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;

import com.cloud.platform.mapper.device.upgrade.DeviceUpgradeMapper;
import com.cloud.platform.req.DeviceUpgradeREQ;
import com.cloud.platform.req.MessageHeadREQ;
import com.cloud.platform.service.IMqttHttpPort;
import com.cloud.platform.service.device.IDeviceLinkFileService;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import com.cloud.platform.service.device.IDeviceLinkInfoService;
import com.cloud.platform.service.device.market.IDevicePatchService;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文件信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Service
public class DeviceUpgradeServiceImpl extends ServiceImpl<DeviceUpgradeMapper, DeviceUpgrade>
             implements IDeviceUpgradeService {
  @Resource
  private IDevicePatchService patchService;
  @Resource
  private IDeviceLinkInfoService infoService;
  @Resource
  private IMqttHttpPort iMqttHttpPort;
  @Autowired
  private IDeviceLinkFileSignService fileSignService;
  @Autowired
  private IDeviceLinkFileService fileService;
  @Resource
  private DeviceUpgradeMapper upgradeMapper;

  @Override
  public Boolean updateUpgrade(String deviceId, Map map) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("du_deviceId",deviceId);
    wrapper.eq("du_jobId", ObjectUtils.isEmpty(map.get("jobId"))?null:Integer.parseInt(map.get("jobId").toString()));
    wrapper.last(" limit 1");
    DeviceUpgrade deviceUpgrade = baseMapper.selectOne(wrapper);
    if (ObjectUtils.isNotEmpty(deviceUpgrade)){
      deviceUpgrade.setProgress(ObjectUtils.isEmpty(map.get("progress"))?null:Integer.parseInt(map.get("progress").toString()));
      deviceUpgrade.setState(ObjectUtils.isEmpty(map.get("state"))?null:Integer.parseInt(map.get("state").toString()));
    }
    baseMapper.updateById(deviceUpgrade);
    return true;
  }

  @Override
  public DeviceUpgrade selectByJobId(String jobId) {

    QueryWrapper wrapper =new QueryWrapper();
    wrapper.eq("du_jobId",jobId);
    DeviceUpgrade deviceUpgrade = baseMapper.selectOne(wrapper);
    return deviceUpgrade;
  }

  @Override
  public Result getJObid() {
    int n=1;
    Map<String,Object> map=new HashMap<>();
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.orderByDesc("du_createTime");
    wrapper.last(" limit 1");
    DeviceUpgrade upgrade = baseMapper.selectOne(wrapper);
    if (!org.springframework.util.ObjectUtils.isEmpty(upgrade)){
      n= upgrade.getJobId()+1;
    }
    List<DevicePatch> aLl = patchService.getALl();
    map.put("num",n);
    map.put("patchList",aLl);
    return Result.ok(map);
  }

  @Override
  public Result exceUpgrade(DeviceUpgradeREQ req) {
    if (ObjectUtils.isEmpty(req)){
      return Result.error("数据不能为空");
    }
    List<String> deviceIds = req.getDeviceIds();
    DeviceUpgrade deviceUpgrade = req.getField();
    if (ListUtils.isEmpty(deviceIds)){
      return Result.error("请选择设备后在进行操作！");
    }
    for (int i = 0; i < deviceIds.size(); i++) {
      deviceUpgrade.setDuId(null);
      Boolean sendmessage = sendmessage(deviceIds.get(i),i, deviceUpgrade);
      deviceUpgrade.setDeviceId(deviceIds.get(i));
      baseMapper.insert(deviceUpgrade);
      if (!sendmessage){
        return Result.error("发送失败");
      }
    }
    return Result.ok();
  }

  public Boolean sendmessage(String n,int i, DeviceUpgrade deviceUpgrade) {
    MessageHeadREQ messageLog = new MessageHeadREQ();
    try {
      int jobIdNum = deviceUpgrade.getJobId() + i;
      deviceUpgrade.setJobId(jobIdNum);
      messageLog.setMid(jobIdNum);
      messageLog.setDeviceId(n);
      String strDateFormat = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
      messageLog.setTimestamp(sdf.format(new Date()));
      messageLog.setType("CMD_SYS_UPGRADE");
      DevicePatch patch = patchService.getById(deviceUpgrade.getDuFileId());
      if (ObjectUtils.isNotEmpty(patch)) {
        DeviceLinkFile file = fileService.getFile(patch.getPatchFileId(),0);
        DeviceLinkFileSign fileSign = fileSignService.getFileSign(file.getFsId());
        if (!org.springframework.util.ObjectUtils.isEmpty(fileSign)) {
          file.setSign(fileSign);
        }
        messageLog.setMsg(null);
        deviceUpgrade.setFile(file);
        messageLog.setParam(deviceUpgrade);
        Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/" + n + "/device/command");
        return aBoolean;
      }
      return false;

    } catch (Exception e) {
      log.error("设备升级报错：{}", e);
    }
    return false;

  }

  @Override
  public ResultVo taskList(DeviceUpgradeREQ req) {
    IPage<DeviceUpgrade> page=new Page<DeviceUpgrade>();
    IPage<DeviceUpgrade> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceUpgrade> taskListResult = upgradeMapper.taskList(page,req);
    return ResultVo.ok(taskListResult.getRecords(),taskListResult.getTotal());
  }

  @Override
  public Result statusQuery(Integer jobId, String deviceId) {
    JSONObject jsonObject=new JSONObject();
    jsonObject.put("jobId",jobId);
    MessageHeadREQ messageLog = new MessageHeadREQ();
    messageLog.setMid(jobId);
    messageLog.setDeviceId(deviceId);
    String strDateFormat = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
    messageLog.setTimestamp(sdf.format(new Date()));
    messageLog.setType("CMD_STATUS_QUERY");
    messageLog.setParam(jsonObject);
    Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/" + deviceId + "/device/command");
    if (aBoolean){
       return Result.ok();
    }
    return Result.error("发送命令失败");
  }
}
