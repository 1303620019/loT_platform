package com.cloud.platform.mapper.device;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.DeviceLinkLinks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 外接设备信息 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Mapper
public interface DeviceLinkLinksMapper extends BaseMapper<DeviceLinkLinks> {

  void insertArrayLinks(@Param("linkLinks") List<DeviceLinkLinks> linkLinks);

}
