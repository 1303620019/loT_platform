package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkDev;
import com.cloud.platform.entity.device.DeviceLinkOs;
import com.cloud.platform.req.DeviceLinkDevREQ;

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

  Boolean updateByDeviceId(String deviceId,String version);

  /**
   * 功能描述: <br>
   * 〈升级列表查询〉
   * @Param: [req]
   * @Return: com.cloud.platform.base.ResultVo
   * @Author: byl
   * @Date:
   */
  ResultVo upgradeSearch(DeviceLinkDevREQ req);
}
