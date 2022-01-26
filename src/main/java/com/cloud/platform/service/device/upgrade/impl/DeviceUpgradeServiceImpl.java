package com.cloud.platform.service.device.upgrade.impl;



import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.cloud.platform.entity.device.DeviceLinkFileSign;
import com.cloud.platform.entity.device.market.DevicePatch;
import com.cloud.platform.entity.device.plan.DeviceUpgradeTask;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;

import com.cloud.platform.entity.device.upgrade.DeviceUpgradeSchedule;
import com.cloud.platform.mapper.device.upgrade.DeviceUpgradeMapper;
import com.cloud.platform.req.DeviceUpgradeREQ;
import com.cloud.platform.req.MessageHeadREQ;
import com.cloud.platform.service.IMqttHttpPort;
import com.cloud.platform.service.device.IDeviceLinkFileService;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import com.cloud.platform.service.device.market.IDevicePatchService;
import com.cloud.platform.service.device.task.IDeviceTaskService;
import com.cloud.platform.service.device.task.IDeviceUpgradeTaskService;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeScheduleService;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  private IDeviceUpgradeScheduleService scheduleService;
  @Resource
  private IDeviceTaskService deviceTaskService;
  @Resource
  private IDeviceUpgradeTaskService taskService;
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
    DeviceUpgradeSchedule upgradeSchedule=new DeviceUpgradeSchedule();
    if (ObjectUtils.isNotEmpty(deviceUpgrade)){
      deviceUpgrade.setProgress(ObjectUtils.isEmpty(map.get("progress"))?null:Integer.parseInt(map.get("progress").toString()));
      deviceUpgrade.setState(ObjectUtils.isEmpty(map.get("state"))?null:Integer.parseInt(map.get("state").toString()));
      upgradeSchedule.setCreateTime(new Date());
      upgradeSchedule.setJobId(deviceUpgrade.getJobId());
      upgradeSchedule.setProgress(ObjectUtils.isEmpty(map.get("progress"))?null:Integer.parseInt(map.get("progress").toString()));
      upgradeSchedule.setState(ObjectUtils.isEmpty(map.get("state"))?null:Integer.parseInt(map.get("state").toString()));
      scheduleService.save(upgradeSchedule);
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
  @Transactional
  public Result exceUpgrade(DeviceUpgradeREQ req) {
    if (ObjectUtils.isEmpty(req)){
      return Result.error("数据不能为空");
    }
    //获取新的工作分区id
    Integer jobId = getJobId();
    //升级任务记录类
    DeviceUpgrade upgrade=new DeviceUpgrade();
    //获取任务计划的补丁
    DeviceUpgradeTask upgradeTask = taskService.getById(req.getDaId());
    if (ObjectUtils.isNotEmpty(upgradeTask)){
       upgrade.setJobId(jobId);
       upgrade.setTaId(req.getDaId());
       //默认按立即执行
       upgrade.setPolicy(0);
       upgrade.setVersion(upgradeTask.getVersions());
       //需求待明确
       upgrade.setUpgradeType(upgradeTask.getPaType());
       upgrade.setDuFileId(upgradeTask.getPaId());
       upgrade.setDeviceId(req.getDeviceId());
       upgrade.setCreateTime(new Date());
       Boolean sendmesage = sendmessage(upgrade);
       if (sendmesage){
         deviceTaskService.editState(req.getDeviceId());
         upgradeTask.setExceState(2);
         upgrade.setExceState(2);
         //保存升级记录
         baseMapper.insert(upgrade);
         taskService.updateById(upgradeTask);
       } else{
         return Result.error("发送失败");
       }
     }
    return Result.ok();
  }
//   public Boolean sendmessage(String n,int i, DeviceUpgrade deviceUpgrade) {  用于版本1
  public Boolean sendmessage(DeviceUpgrade deviceUpgrade) {
    MessageHeadREQ messageLog = new MessageHeadREQ();
    try {
      messageLog.setMid(deviceUpgrade.getJobId());
      messageLog.setDeviceId(deviceUpgrade.getDeviceId());
      String strDateFormat = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
      messageLog.setTimestamp(sdf.format(new Date()));
      messageLog.setType("CMD_SYS_UPGRADE");
      DevicePatch patch = patchService.getById(deviceUpgrade.getDuFileId());
      if (ObjectUtils.isNotEmpty(patch)) {
        DeviceLinkFile file = fileService.getFile(patch.getPatchFileId(),0);
           //添加验证签名
          if (ObjectUtils.isNotEmpty(file)){
            DeviceLinkFileSign fileSign = fileSignService.getFileSign(file.getFsId());
            if (ObjectUtils.isNotEmpty(fileSign)) {
              file.setSign(fileSign);
            }
          }
        messageLog.setMsg(null);
        deviceUpgrade.setFile(file);
        messageLog.setParam(deviceUpgrade);
        Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/" + deviceUpgrade.getDeviceId() + "/device/command");
        return aBoolean;
      }
      return false;

    } catch (Exception e) {
      log.error("设备升级报错：{}", e);
    }
    return false;

  }

  @Override
  public ResultVo upgradeLog(DeviceUpgradeREQ req) {
    IPage<DeviceUpgrade> page=new Page<DeviceUpgrade>();
    IPage<DeviceUpgrade> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceUpgrade> taskLogResult = upgradeMapper.upgradeLog(page,req);
    return ResultVo.ok(taskLogResult.getRecords(),taskLogResult.getTotal());
  }

  @Override
  public Result againExce(String duId) {

    DeviceUpgrade upgrade = baseMapper.selectById(duId);
    Boolean sendmessage = sendmessage(upgrade);
    if (sendmessage){
      upgradeMapper.updateResultState(upgrade.getDuId());
    }
    return Result.ok();
  }

  public Integer getJobId(){
    int n=1;
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.orderByDesc("du_createTime");
    wrapper.last(" limit 1");
    DeviceUpgrade upgradeJob = baseMapper.selectOne(wrapper);
    if (ObjectUtils.isNotEmpty(upgradeJob)){
      n= upgradeJob.getJobId()+1;
    }
    return n;
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

  @Override
  public Result progress(Integer jobId) {
    QueryWrapper wrapper =new QueryWrapper();
//    wrapper.eq("",)

    return null;
  }
}
