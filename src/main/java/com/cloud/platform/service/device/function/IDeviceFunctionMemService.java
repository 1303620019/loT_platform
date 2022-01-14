package com.cloud.platform.service.device.function;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.function.DeviceFunctionMem;

import java.util.Map;

/**
 * <p>
 * 内存使用信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
public interface IDeviceFunctionMemService extends IService<DeviceFunctionMem> {

  String saveFunctionMen(Map map);

}
