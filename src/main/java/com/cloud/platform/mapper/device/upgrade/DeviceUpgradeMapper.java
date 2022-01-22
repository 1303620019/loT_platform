package com.cloud.platform.mapper.device.upgrade;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.entity.device.DeviceArchives;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DeviceUpgradeREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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

  IPage<DeviceUpgrade> taskList(IPage<DeviceUpgrade> page, @Param("req") DeviceUpgradeREQ req);
  IPage<DeviceUpgrade> upgradeLog(IPage<DeviceUpgrade> page, @Param("req") DeviceUpgradeREQ req);
  @Update("update   t_device_upgrade  set du_result=NULL where du_id=#{id}")
  void updateResultState(@Param("id") String id);
}
