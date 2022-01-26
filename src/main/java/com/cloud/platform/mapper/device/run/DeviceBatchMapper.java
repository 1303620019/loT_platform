package com.cloud.platform.mapper.device.run;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.entity.device.run.DeviceBatch;
import com.cloud.platform.entity.device.run.DeviceRecall;
import com.cloud.platform.req.DeviceBatchInfoREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备批次 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Mapper
public interface DeviceBatchMapper extends BaseMapper<DeviceBatch> {
  IPage<DeviceBatch> getBatchInfoByBatchId(IPage<DeviceBatch> page, @Param("req") DeviceBatchInfoREQ req);
}
