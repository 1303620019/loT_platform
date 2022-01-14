package com.cloud.platform.service.device.function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.function.DeviceFunctionTemperature;

import java.util.Map;

/**
 * <p>
 * 主动上报的上报时间间隔 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
public interface IDeviceFunctionTemperatureService extends IService<DeviceFunctionTemperature> {


  Boolean   saveTemperature(Map map);

}
