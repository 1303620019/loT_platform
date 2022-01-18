package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkAi;

import java.util.Map;

/**
 * <p>
 * AI模块信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-17
 */
public interface IDeviceLinkAiService extends IService<DeviceLinkAi> {

  Boolean saveAi(Map map);
}
