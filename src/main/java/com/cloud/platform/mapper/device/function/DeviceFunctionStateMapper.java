package com.cloud.platform.mapper.device.function;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.DeviceLinkLinks;
import com.cloud.platform.entity.device.function.DeviceFunctionState;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 接口运行状态 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
public interface DeviceFunctionStateMapper extends BaseMapper<DeviceFunctionState> {
  void insertArrayStates(@Param("stateList") List<DeviceFunctionState> stateList);
}
