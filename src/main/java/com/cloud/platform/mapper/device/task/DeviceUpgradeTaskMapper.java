package com.cloud.platform.mapper.device.task;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
import com.cloud.platform.entity.device.task.DeviceUpgradeTask;
import com.cloud.platform.req.DeviceUpgradeTaskREQ;
import com.cloud.platform.req.FunctionREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 计划任务表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Mapper
public interface DeviceUpgradeTaskMapper extends BaseMapper<DeviceUpgradeTask> {

  IPage<DeviceUpgradeTask> searche(IPage<DeviceUpgradeTask> page, @Param("req") DeviceUpgradeTaskREQ  req);
}
