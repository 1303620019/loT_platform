package com.cloud.platform.mapper.device;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.entity.device.DeviceArchives;
import com.cloud.platform.entity.device.DeviceLinkOs;
import com.cloud.platform.req.DeviceArchivesREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备档案 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Mapper
public interface DeviceArchivesMapper extends BaseMapper<DeviceArchives> {
 IPage<DeviceArchives> search(IPage<DeviceArchives> page,@Param("req") DeviceArchivesREQ req);
 IPage<DeviceArchives> upgradeSearch(IPage<DeviceArchives> page,@Param("req") DeviceArchivesREQ req);
}
