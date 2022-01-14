package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.cloud.platform.mapper.device.DeviceLinkFileMapper;
import com.cloud.platform.service.device.IDeviceLinkFileService;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkFileServiceImpl extends ServiceImpl<DeviceLinkFileMapper, DeviceLinkFile>
        implements IDeviceLinkFileService {

  @Autowired
  private IDeviceLinkFileSignService  signService;
  @Override
  public DeviceLinkFile getFile(String dlfId) {
    DeviceLinkFile deviceLinkFile = baseMapper.selectById(dlfId);
    return deviceLinkFile;
  }
}
