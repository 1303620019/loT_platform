package com.cloud.platform.service.device.run;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.run.DeviceBatch;
import com.cloud.platform.req.DeviceBatchInfoREQ;

/**
 * <p>
 * 设备批次 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
public interface IDeviceBatchService extends IService<DeviceBatch> {
  ResultVo getBatchInfoByBatchId(DeviceBatchInfoREQ req);
}
