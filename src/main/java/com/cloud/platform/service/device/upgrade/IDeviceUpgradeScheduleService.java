package com.cloud.platform.service.device.upgrade;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.upgrade.DeviceUpgradeSchedule;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DeviceUpgradeScheduleREQ;

/**
 * <p>
 * 升级进度表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-21
 */
public interface IDeviceUpgradeScheduleService extends IService<DeviceUpgradeSchedule> {

   ResultVo search(DeviceUpgradeScheduleREQ req);
}
