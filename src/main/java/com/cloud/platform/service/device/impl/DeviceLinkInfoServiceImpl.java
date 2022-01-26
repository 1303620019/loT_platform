package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cloud.platform.entity.device.DeviceLinkInfo;
import com.cloud.platform.mapper.device.DeviceLinkInfoMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.req.FunctionREQ;
import com.cloud.platform.service.device.IDeviceLinkInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备主信息表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkInfoServiceImpl extends ServiceImpl<DeviceLinkInfoMapper, DeviceLinkInfo>
        implements IDeviceLinkInfoService {
  @Autowired
  private  DeviceLinkInfoMapper linkInfoMapper;
  @Override
  public String saveLinkInfo(Map map) {
    DeviceLinkInfo linkInfo = createLinkInfo(map);
    Integer integer = linkInfoMapper.saveLinkInfo(linkInfo);
    return (Long.parseLong(linkInfo.getDilId())-1)+"";
  }

  @Override
  public DeviceLinkInfo getLinkInfo(DeviceLinkDevREQ req) {
    String deviceId = req.getDeviceId();
    String mid = req.getMids();
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("dil_mid",mid);
    wrapper.eq("dil_deviceId",deviceId);
    wrapper.orderByDesc("dil_createTime");
    wrapper.last(" limit 1");
    DeviceLinkInfo linkInfo = baseMapper.selectOne(wrapper);
    return linkInfo;
  }

  public DeviceLinkInfo  createLinkInfo(Map map) {
    DeviceLinkInfo linkInfo = new DeviceLinkInfo();
    linkInfo.setDilMid(Integer.parseInt(map.get("mid").toString()));
    linkInfo.setDilDeviceid(ObjectUtils.isEmpty(map.get("deviceId")) ? null : map.get("deviceId").toString());
    linkInfo.setDilTimestamp(ObjectUtils.isEmpty(map.get("timestamp")) ? null : map.get("timestamp").toString());
    linkInfo.setDilType(ObjectUtils.isEmpty(map.get("type")) ? null : map.get("type").toString());
    linkInfo.setDilMsg(ObjectUtils.isEmpty(map.get("msg")) ? null : map.get("msg").toString());
    linkInfo.setDilCreatetime(new Date());
    return linkInfo;
  }

}
