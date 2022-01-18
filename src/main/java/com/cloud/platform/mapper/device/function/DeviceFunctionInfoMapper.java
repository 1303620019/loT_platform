package com.cloud.platform.mapper.device.function;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkOs;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
import com.cloud.platform.req.FunctionREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 设备运行状态 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Mapper
public interface DeviceFunctionInfoMapper extends BaseMapper<DeviceFunctionInfo> {
  IPage<DeviceFunctionInfo> search(IPage<DeviceFunctionInfo> page, @Param("req") FunctionREQ req);
  IPage<DeviceFunctionInfo> cfgSearch(IPage<DeviceFunctionInfo> page, @Param("req") FunctionREQ req);
}
