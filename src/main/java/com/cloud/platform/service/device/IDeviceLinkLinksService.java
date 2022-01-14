package com.cloud.platform.service.device;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkLinks;

import java.util.Map;

/**
 * <p>
 * 外接设备信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkLinksService extends IService<DeviceLinkLinks> {
  Boolean saveLinkLinks(Map map);
}
