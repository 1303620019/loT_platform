package com.cloud.platform.mapper.device;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.device.DeviceLinkInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 设备主信息表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Mapper
public interface DeviceLinkInfoMapper extends BaseMapper<DeviceLinkInfo> {



  Integer saveLinkInfo(DeviceLinkInfo linkInfo);
}
