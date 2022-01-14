package com.cloud.platform.mapper.device;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.DeviceLinkDev;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备信息字段 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Mapper
public interface DeviceLinkDevMapper extends BaseMapper<DeviceLinkDev> {

  DeviceLinkDev  selectOneByDeviceId(@Param("deviceId") String deviceId);
}
