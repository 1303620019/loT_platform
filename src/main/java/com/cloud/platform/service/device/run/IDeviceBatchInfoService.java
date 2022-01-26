package com.cloud.platform.service.device.run;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.run.DeviceBatchInfo;
import com.cloud.platform.req.DeviceBatchInfoREQ;

/**
 * <p>
 * 设备批次信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
public interface IDeviceBatchInfoService extends IService<DeviceBatchInfo> {

  ResultVo search( DeviceBatchInfoREQ req);
  Result recallList();
  Result saveBatch(DeviceBatchInfoREQ req);

}
