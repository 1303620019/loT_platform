package com.cloud.platform.mapper.device;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.DeviceMessageLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 消息记录 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Mapper
public interface DeviceMessageLogMapper extends BaseMapper<DeviceMessageLog> {

}
