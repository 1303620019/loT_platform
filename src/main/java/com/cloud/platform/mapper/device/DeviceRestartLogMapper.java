package com.cloud.platform.mapper.device;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.DeviceRestartLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 设备重启记录 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Mapper
public interface DeviceRestartLogMapper extends BaseMapper<DeviceRestartLog> {

}
