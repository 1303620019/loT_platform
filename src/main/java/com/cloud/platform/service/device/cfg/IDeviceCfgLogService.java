package com.cloud.platform.service.device.cfg;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.cfg.DeviceCfgLog;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DeviceCfgLogREQ;

/**
 * <p>
 * 配置管理记录 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-17
 */
public interface IDeviceCfgLogService extends IService<DeviceCfgLog> {

  ResultVo search(DeviceCfgLogREQ req);
  Result del(String id);
}
