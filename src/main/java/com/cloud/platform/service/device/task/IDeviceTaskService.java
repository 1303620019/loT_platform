package com.cloud.platform.service.device.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.task.DeviceTask;

/**
 * <p>
 * 计划任务关系表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
public interface IDeviceTaskService extends IService<DeviceTask> {


  void del(String taId);

}
