package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkInfo;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.req.FunctionREQ;

import java.util.Map;

/**
 * <p>
 * 设备主信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkInfoService extends IService<DeviceLinkInfo> {
  String saveLinkInfo(Map map);
  DeviceLinkInfo getLinkInfo(DeviceLinkDevREQ req);
}
