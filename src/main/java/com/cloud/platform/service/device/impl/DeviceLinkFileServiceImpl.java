package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.cloud.platform.mapper.device.DeviceLinkFileMapper;
import com.cloud.platform.service.device.IDeviceLinkFileService;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

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

  @Override
  public Boolean saveFile(Map map) {
    DeviceLinkFile file =new DeviceLinkFile();
    file.setDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
    file.setName(ObjectUtils.isEmpty(map.get("name"))?null:map.get("name").toString());
    file.setFiletype(ObjectUtils.isEmpty(map.get("fileType"))?null:map.get("fileType").toString());
    file.setSize(ObjectUtils.isEmpty(map.get("size"))?null:Integer.parseInt(map.get("size").toString()));
    file.setMd5(ObjectUtils.isEmpty(map.get("md5"))?null:map.get("md5").toString());
    file.setFsId(ObjectUtils.isEmpty(map.get("signId"))?null:map.get("signId").toString());
    file.setUrl(ObjectUtils.isEmpty(map.get("url"))?null:map.get("url").toString());
    file.setDlfCreatetime(new Date());
    int insert = baseMapper.insert(file);
    return true;
  }
}
