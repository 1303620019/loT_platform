package com.cloud.platform.service.device.function;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.function.DeviceFunctionAiapp;

import java.util.Map;

/**
 * <p>
 * Ai运行信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
public interface IDeviceFunctionAiappService extends IService<DeviceFunctionAiapp> {


  Boolean saveFunctionAiapp(Map map);
}
