package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkCpu;

import java.util.Map;

/**
 * <p>
 * 表Cpu 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkCpuService extends IService<DeviceLinkCpu> {

  Boolean saveLinkCpu(Map map);


}
