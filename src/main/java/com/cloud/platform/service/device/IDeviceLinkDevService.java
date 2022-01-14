package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkDev;

import java.util.Map;

/**
 * <p>
 * 设备信息字段 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkDevService extends IService<DeviceLinkDev> {

  String saveCreatLinkDev(Map map);

  Boolean upateDevStatus(Map map);
}
