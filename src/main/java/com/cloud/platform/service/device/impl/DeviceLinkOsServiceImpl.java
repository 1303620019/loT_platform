package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkDev;
import com.cloud.platform.entity.device.DeviceLinkOs;
import com.cloud.platform.mapper.device.DeviceLinkOsMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.service.device.IDeviceLinkOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 操作系统信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkOsServiceImpl extends ServiceImpl<DeviceLinkOsMapper, DeviceLinkOs>
        implements IDeviceLinkOsService {

  @Autowired
  private DeviceLinkOsMapper osMapper;
  @Override
  public Boolean saveCreatLinkOs(Map map) {
    if (!ObjectUtils.isEmpty(map.get("os"))) {
      Map<String, Object> os = JSON.parseObject(map.get("os").toString(), Map.class);
      DeviceLinkOs linkOs = createLinkOs(os);
      linkOs.setDloDlDId(map.get("dliId").toString());
      baseMapper.insert(linkOs);
    }
    return true;
  }


  @Override
  public Boolean updateByDeviceId(String deviceId,String version) {
    QueryWrapper wrapper =new QueryWrapper();
    wrapper.eq("dlo_deviceId",deviceId);
    wrapper.orderByDesc("dld_createTime");
    wrapper.last(" limit 1");
    DeviceLinkOs deviceLinkOs = baseMapper.selectOne(wrapper);
    deviceLinkOs.setDloVersion(version);
    baseMapper.updateById(deviceLinkOs);
    return true;
  }
  public DeviceLinkOs createLinkOs(Map map){
    DeviceLinkOs linkOs =new DeviceLinkOs();
    linkOs.setDloDistro(ObjectUtils.isEmpty(map.get("distro"))?null:map.get("distro").toString());
    linkOs.setDloVersion(ObjectUtils.isEmpty(map.get("version"))?null:map.get("version").toString());
    linkOs.setDloKernel(ObjectUtils.isEmpty(map.get("kernel"))?null:map.get("kernel").toString());
    linkOs.setDloSoftversion(ObjectUtils.isEmpty(map.get("softVersion"))?null:map.get("softVersion").toString());
    linkOs.setDloPatchversion(ObjectUtils.isEmpty(map.get("patchVersion"))?null:map.get("patchVersion").toString());
    linkOs.setDloPatchversion(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
    linkOs.setDloCreatetime(new Date());
    return linkOs;
  }


  @Override
  public ResultVo upgradeSearch(DeviceLinkDevREQ req) {
    IPage<DeviceLinkOs> page=new Page<DeviceLinkOs>();
    IPage<DeviceLinkDev> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceLinkOs> deviceLinkOsIPage = osMapper.upgradeSearch(page, req);
    return ResultVo.ok(deviceLinkOsIPage.getRecords(),deviceLinkOsIPage.getTotal());
  }
}
