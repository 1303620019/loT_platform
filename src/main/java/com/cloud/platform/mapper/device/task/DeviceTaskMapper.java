package com.cloud.platform.mapper.device.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.task.DeviceTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 计划任务关系表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Mapper
public interface DeviceTaskMapper extends BaseMapper<DeviceTask> {

}
