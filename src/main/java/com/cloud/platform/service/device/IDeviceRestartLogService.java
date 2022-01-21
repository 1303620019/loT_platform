package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.DeviceRestartLog;
import com.cloud.platform.req.DeviceRestartLogREQ;
import io.swagger.models.auth.In;

/**
 * <p>
 * 设备重启记录 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
public interface IDeviceRestartLogService extends IService<DeviceRestartLog> {

  Integer saveLog(DeviceRestartLog restartLog);

  Boolean editLog(String deviceId,String code);
  ResultVo search(DeviceRestartLogREQ req);
}
