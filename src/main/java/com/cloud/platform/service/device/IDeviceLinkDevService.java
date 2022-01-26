package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkDev;
import com.cloud.platform.req.DeviceLinkDevREQ;

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

  ResultVo search(DeviceLinkDevREQ req);
  Result baseInfo(DeviceLinkDevREQ req);



}
