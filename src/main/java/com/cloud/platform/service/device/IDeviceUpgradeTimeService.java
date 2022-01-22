package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceUpgradeTime;

/**
 * <p>
 * 时间同步记录 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-22
 */
public interface IDeviceUpgradeTimeService extends IService<DeviceUpgradeTime> {


  Integer getMid();
}
