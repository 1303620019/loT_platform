package com.cloud.platform.mapper.device.cfg;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.cfg.DeviceCfgLog;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 配置管理记录 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-17
 */
@Mapper
public interface DeviceCfgLogMapper extends BaseMapper<DeviceCfgLog> {

  Integer del(@Param("dcid") String dcid);
}
