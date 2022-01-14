package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkMem;

import java.util.Map;

/**
 * <p>
 * 内存信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkMemService extends IService<DeviceLinkMem> {

  Boolean savelinkMem(Map<String,Object> map);
}
