package com.cloud.platform.service.device.upgrade;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;

import java.util.Map;

/**
 * <p>
 * 设备主信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceUpgradeService extends IService<DeviceUpgrade> {


   Boolean updateUpgrade(String deviceId,Map map);
   DeviceUpgrade  selectByJobId(String jobId);
}
