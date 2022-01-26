package com.cloud.platform.service.device.task.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.plan.DeviceTask;
import com.cloud.platform.mapper.device.task.DeviceTaskMapper;
import com.cloud.platform.service.device.task.IDeviceTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 计划任务关系表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Service
public class DeviceTaskServiceImpl
        extends ServiceImpl<DeviceTaskMapper, DeviceTask> implements IDeviceTaskService {
  @Resource
  private  DeviceTaskMapper taskMapper;
  @Override
  public void del(String taId) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("dt_taId",taId);
    baseMapper.delete(wrapper);

  }

  @Override
  public void editState(String deviceId) {
    taskMapper.editState(deviceId);
  }
}
