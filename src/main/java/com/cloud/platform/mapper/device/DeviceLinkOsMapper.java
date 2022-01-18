package com.cloud.platform.mapper.device;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.entity.device.DeviceLinkOs;
import com.cloud.platform.req.DeviceLinkDevREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 操作系统信息 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Mapper
public interface DeviceLinkOsMapper extends BaseMapper<DeviceLinkOs> {



 IPage<DeviceLinkOs> upgradeSearch(IPage<DeviceLinkOs> page,@Param("req") DeviceLinkDevREQ req);
}
