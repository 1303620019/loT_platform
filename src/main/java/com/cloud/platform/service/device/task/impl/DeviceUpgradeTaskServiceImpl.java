package com.cloud.platform.service.device.task.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.market.DevicePatch;
import com.cloud.platform.entity.device.task.DeviceTask;
import com.cloud.platform.entity.device.task.DeviceUpgradeTask;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;
import com.cloud.platform.mapper.device.task.DeviceUpgradeTaskMapper;
import com.cloud.platform.req.DeviceUpgradeREQ;
import com.cloud.platform.req.DeviceUpgradeTaskREQ;
import com.cloud.platform.service.device.market.IDevicePatchService;
import com.cloud.platform.service.device.task.IDeviceTaskService;
import com.cloud.platform.service.device.task.IDeviceUpgradeTaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 计划任务表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Service
public class DeviceUpgradeTaskServiceImpl
        extends ServiceImpl<DeviceUpgradeTaskMapper, DeviceUpgradeTask> implements IDeviceUpgradeTaskService {
  @Resource
  private DeviceUpgradeTaskMapper taskMapper;
  @Resource
  private IDeviceTaskService taskService;
  @Resource
  private IDevicePatchService  patchService;

  @Override
  public ResultVo searche(DeviceUpgradeTaskREQ req) {
    IPage<DeviceUpgradeTask> searche = taskMapper.searche(req.getPage(), req);
    return ResultVo.ok(searche.getRecords(),searche.getTotal());
  }

  @Override
  @Transactional
  public Result saveTask(DeviceUpgradeTaskREQ req) {
    DeviceUpgradeTask upgradeTask = req.getField();
    upgradeTask.setCreataTime(new Date());
    upgradeTask.setExceState(0);
    int insert = baseMapper.insert(upgradeTask);
    if (insert>0){
      List<String> daIds = req.getDaIds();
      daIds.forEach(n->{
        DeviceTask task=new  DeviceTask();
        task.setState(0);
        task.setArcId(n);
        task.setTaId(upgradeTask.getId());
        task.setCreataTime(new Date());
        taskService.save(task);
      });
    }

    return Result.ok();
  }

  @Override
  public Result getId() {
    int n=1;
    Map<String,Object> map=new HashMap<>();
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.orderByDesc("dut_creataTime");
    wrapper.last(" limit 1");
    DeviceUpgradeTask deviceUpgradeTask = baseMapper.selectOne(wrapper);
    if (!ObjectUtils.isEmpty(deviceUpgradeTask)){
      String num = deviceUpgradeTask.getNum();
      n= Integer.parseInt(num)+1;
    }
    List<DevicePatch> aLl = patchService.getALl();
    map.put("num",n);
    map.put("patchList",aLl);
    return Result.ok(map);
  }

  @Override
  public Result del(String id) {
    baseMapper.deleteById(id);
    return Result.ok();
  }
//  @Override
//  public Result saveTask(DeviceUpgradeTask task) {
//    if (task.getExecType() == 0){
//      task.setExecTime(new Date());
//    }
//    task.setExceState(0);
//    task.setCreataTime(new Date());
//    baseMapper.insert(task);
//    return Result.ok();
//  }


  @Override
  public Result editExceState(String taskId) {
    DeviceUpgradeTask upgradeTask = baseMapper.selectById(taskId);
    upgradeTask.setExceState(1);
    int i = baseMapper.updateById(upgradeTask);

    return Result.ok();
  }

  @Override
  public Result getUpgradeTask(String taskId) {
    DeviceUpgradeTask upgradeTask = baseMapper.selectById(taskId);
    return Result.ok(upgradeTask);
  }

  @Override
  public Result editUpgradeTask(DeviceUpgradeTaskREQ req) {
    DeviceUpgradeTask upgradeTask = req.getField();
    upgradeTask.setEditTime(new Date());
    upgradeTask.setExceState(0);
    //先删除绑定计划的设备数据
    taskService.del(upgradeTask.getId());
    int insert = baseMapper.updateById(upgradeTask);
    if (insert>0){
      List<String> daIds = req.getDaIds();
      daIds.forEach(n->{
        DeviceTask task=new  DeviceTask();
        task.setState(0);
        task.setArcId(n);
        task.setTaId(upgradeTask.getId());
        task.setCreataTime(new Date());
        taskService.save(task);
      });
    }

    return Result.ok();
  }

}
