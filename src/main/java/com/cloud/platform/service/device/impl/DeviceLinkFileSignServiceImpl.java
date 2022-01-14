package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkFileSign;
import com.cloud.platform.mapper.device.DeviceLinkFileSignMapper;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  数字签证信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkFileSignServiceImpl extends ServiceImpl<DeviceLinkFileSignMapper, DeviceLinkFileSign> implements IDeviceLinkFileSignService {

  @Override
  public DeviceLinkFileSign getFileSign(String fsId) {
    DeviceLinkFileSign deviceLinkFileSign = baseMapper.selectById(fsId);
    return deviceLinkFileSign;
  }
}
