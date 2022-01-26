package com.cloud.platform.service.device;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceArchives;
import com.cloud.platform.req.DeviceArchivesREQ;

/**
 * <p>
 * 设备档案 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
public interface IDeviceArchivesService extends IService<DeviceArchives> {

  Result saveArchives(DeviceArchives archives);
  Result getArchives(String id);
  Result edit(DeviceArchives archives);
  Result del(String id);
  DeviceArchives getArchivesByDeviceId(String deviceId,String mfgInfo);
  ResultVo search(DeviceArchivesREQ req);
  ResultVo searchArc(DeviceArchivesREQ req);
  ResultVo upgradeSearch(DeviceArchivesREQ req);
}
