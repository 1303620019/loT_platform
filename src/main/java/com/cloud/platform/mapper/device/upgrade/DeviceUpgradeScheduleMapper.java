package com.cloud.platform.mapper.device.upgrade;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.upgrade.DeviceUpgradeSchedule;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 升级进度表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-21
 */
@Mapper
public interface DeviceUpgradeScheduleMapper extends BaseMapper<DeviceUpgradeSchedule> {

}
