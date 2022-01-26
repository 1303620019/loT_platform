package com.cloud.platform.mapper.device.run;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.entity.device.DeviceArchives;
import com.cloud.platform.entity.device.run.DeviceRecall;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DeviceBatchInfoREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 召回类型列表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Mapper
public interface DeviceRecallMapper extends BaseMapper<DeviceRecall> {

}
