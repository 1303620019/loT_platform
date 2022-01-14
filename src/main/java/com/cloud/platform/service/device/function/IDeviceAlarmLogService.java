package com.cloud.platform.service.device.function;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.function.DeviceAlarmLog;

import java.util.Map;

/**
 * <p>
 * 设备告警事件 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
public interface IDeviceAlarmLogService extends IService<DeviceAlarmLog> {
  Boolean  saveAlarmLog(Map map);
}
