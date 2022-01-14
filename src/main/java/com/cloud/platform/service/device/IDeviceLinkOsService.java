package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkOs;

import java.util.Map;

/**
 * <p>
 * 操作系统信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkOsService extends IService<DeviceLinkOs> {
  Boolean saveCreatLinkOs(Map map);
}
