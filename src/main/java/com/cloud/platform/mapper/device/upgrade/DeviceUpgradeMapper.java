package com.cloud.platform.mapper.device.upgrade;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 设备升级信息接口
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Mapper
public interface DeviceUpgradeMapper extends BaseMapper<DeviceUpgrade> {

}
