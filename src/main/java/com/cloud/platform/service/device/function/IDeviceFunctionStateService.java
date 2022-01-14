package com.cloud.platform.service.device.function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.function.DeviceFunctionState;

import java.util.Map;

/**
 * <p>
 * 接口运行状态 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
public interface IDeviceFunctionStateService extends IService<DeviceFunctionState> {
   Boolean saveFunctionState(Map map);
}
