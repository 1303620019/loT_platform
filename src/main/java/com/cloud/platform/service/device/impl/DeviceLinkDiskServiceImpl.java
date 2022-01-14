package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkDisk;
import com.cloud.platform.mapper.device.DeviceLinkDiskMapper;
import com.cloud.platform.service.device.IDeviceLinkDiskService;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 内存信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkDiskServiceImpl extends ServiceImpl<DeviceLinkDiskMapper, DeviceLinkDisk>
        implements IDeviceLinkDiskService {


  public Boolean  saveLinkDisk(Map map){
    if (!ObjectUtils.isEmpty(map.get("disk"))){
      Map<String, Object> disk = JSON.parseObject(map.get("disk").toString(), Map.class);
      DeviceLinkDisk linkDisk = createLinkMen(disk);
      linkDisk.setDldDliId(map.get("dliId").toString());
      baseMapper.insert(linkDisk);
    }

    return  true;

  }


  public DeviceLinkDisk createLinkMen(Map map){

    DeviceLinkDisk linkDisk=new DeviceLinkDisk();
    linkDisk.setDldDisk(ObjectUtils.isEmpty(map.get("disk"))?null:Integer.parseInt(map.get("disk").toString()));
    linkDisk.setDldDisklmt(ObjectUtils.isEmpty(map.get("diskLmt"))?null:Integer.parseInt(map.get("diskLmt").toString()));
    linkDisk.setDldCreatetime(new Date());
   return linkDisk;
  }
}
