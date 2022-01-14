package com.cloud.platform.service.device;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.device.DeviceLinkFileSign;

/**
 * <p>
 *  数字签证信息 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
public interface IDeviceLinkFileSignService extends IService<DeviceLinkFileSign> {

  DeviceLinkFileSign  getFileSign(String fsId);

}
