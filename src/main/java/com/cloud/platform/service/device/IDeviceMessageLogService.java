package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.comm.Result;
import com.cloud.platform.entity.device.DeviceMessageLog;

import java.util.Map;

/**
 * <p>
 * 消息记录 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceMessageLogService extends IService<DeviceMessageLog> {

  /**
  * 功能描述: <br>
  * 〈保存信息〉
  * @Param: [map]
  * @Return: com.cloud.platform.base.Result
  * @Author: byl
  * @Date:
  */
    Result  saveMessage(Map<String,Object>map);
}
