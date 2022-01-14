package com.cloud.platform.service.device.function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.function.DeviceFunctionRepperiod;

import java.util.Map;

/**
 * <p>
 * 运行温度监控 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
public interface IDeviceFunctionRepperiodService extends IService<DeviceFunctionRepperiod> {
  Boolean   saveRepperiod(Map map);
}
