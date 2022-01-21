package com.cloud.platform.mapper.device.function;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.DeviceLinkLinks;
import com.cloud.platform.entity.device.function.DeviceFunctionAiapp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Ai运行信息 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Mapper
public interface DeviceFunctionAiappMapper extends BaseMapper<DeviceFunctionAiapp> {
  void insertArrayAiapp(@Param("aiapp") List<DeviceFunctionAiapp> aiapp);
}
