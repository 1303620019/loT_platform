package com.cloud.platform.service.device.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.task.DeviceUpgradeTask;
import com.cloud.platform.req.DeviceUpgradeREQ;
import com.cloud.platform.req.DeviceUpgradeScheduleREQ;
import com.cloud.platform.req.DeviceUpgradeTaskREQ;
import com.sun.org.apache.regexp.internal.RE;

/**
 * <p>
 * 计划任务表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
public interface IDeviceUpgradeTaskService extends IService<DeviceUpgradeTask> {

 ResultVo searche(DeviceUpgradeTaskREQ req);
 Result del(String id);
 Result getId();
 Result editExceState(String taskId);
// Result saveTask(DeviceUpgradeTask task);

 Result saveTask(DeviceUpgradeTaskREQ req);
 Result editUpgradeTask(DeviceUpgradeTaskREQ req);
 ResultVo patchSearch(DeviceUpgradeTaskREQ req);
 Result getUpgradeTask(String taskId);
}
