package com.cloud.platform.mapper.device.market;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.market.DevicePatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统补丁信息表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Mapper
public interface DevicePatchMapper extends BaseMapper<DevicePatch> {


  Integer editState(@Param("paState") Integer paState,@Param("paId") String paId);
}
