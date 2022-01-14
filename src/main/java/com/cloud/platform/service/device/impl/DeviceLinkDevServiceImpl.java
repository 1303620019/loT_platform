package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkDev;
import com.cloud.platform.mapper.device.DeviceLinkDevMapper;
import com.cloud.platform.service.device.IDeviceLinkDevService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 设备信息字段 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkDevServiceImpl extends ServiceImpl<DeviceLinkDevMapper, DeviceLinkDev>
        implements IDeviceLinkDevService {

  @Override
  public String saveCreatLinkDev(Map map) {
    if (!ObjectUtils.isEmpty(map.get("dev"))) {
      Map<String, Object> dev = JSON.parseObject(map.get("dev").toString(), Map.class);
      dev.put("deviceId",map.get("deviceId"));
      DeviceLinkDev linkDev = createLinkDev(dev);
      linkDev.setDldDliId(map.get("dliIdLog").toString());
      baseMapper.insert(linkDev);
      return linkDev.getDldId();
    }
    return null;
  }

  @Override
  public Boolean upateDevStatus(Map map) {
    DeviceLinkDev linkDev = baseMapper.selectOneByDeviceId(map.get("deviceId").toString());
    if (!ObjectUtils.isEmpty(linkDev)){
      linkDev.setDldDevStatusNum(1);
      linkDev.setDldBreakReason(ObjectUtils.isEmpty(map.get("reason"))?null:map.get("reason").toString());
      baseMapper.updateById(linkDev);
    }

    return true;
  }

  public DeviceLinkDev createLinkDev(Map map){
    DeviceLinkDev linkDev=new DeviceLinkDev();
    linkDev.setDldDevname(ObjectUtils.isEmpty(map.get("devName"))?null:map.get("devName").toString());
    linkDev.setDldDevtype(ObjectUtils.isEmpty(map.get("devType"))?null:map.get("devType").toString());
    linkDev.setDldMfginfo(ObjectUtils.isEmpty(map.get("mfgInfo"))?null:map.get("mfgInfo").toString());
    linkDev.setDldDevstatus(ObjectUtils.isEmpty(map.get("devStatus"))?null:map.get("devStatus").toString());
    linkDev.setDldHardversion(ObjectUtils.isEmpty(map.get("hardVersion"))?null:map.get("hardVersion").toString());
    linkDev.setDldDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
    linkDev.setDldDevStatusNum(0);
    linkDev.setDldCreatetime(new Date());
    return linkDev;
  }

}
