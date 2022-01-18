package com.cloud.platform.service.device.upgrade;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.upgrade.DeviceUpgradeResult;

import java.util.Map;

/**
 * <p>
 * 设备升级结果 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-14
 */
public interface IDeviceUpgradeResultService extends IService<DeviceUpgradeResult> {

  Boolean saveUpgradeResult(Map map);
}
