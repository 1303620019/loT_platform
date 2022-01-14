package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkOs;
import com.cloud.platform.mapper.device.DeviceLinkOsMapper;
import com.cloud.platform.service.device.IDeviceLinkOsService;
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

  @Override
  public Boolean saveCreatLinkOs(Map map) {
    if (!ObjectUtils.isEmpty(map.get("os"))) {
      Map<String, Object> os = JSON.parseObject(map.get("os").toString(), Map.class);
      DeviceLinkOs linkOs = createLinkOs(os);
      linkOs.setDloDliId(map.get("dliId").toString());
      baseMapper.insert(linkOs);
    }
    return true;
  }


  public DeviceLinkOs createLinkOs(Map map){
    DeviceLinkOs linkOs =new DeviceLinkOs();
    linkOs.setDloDistro(ObjectUtils.isEmpty(map.get("distro"))?null:map.get("distro").toString());
    linkOs.setDloVersion(ObjectUtils.isEmpty(map.get("version"))?null:map.get("version").toString());
    linkOs.setDloKernel(ObjectUtils.isEmpty(map.get("kernel"))?null:map.get("kernel").toString());
    linkOs.setDloSoftversion(ObjectUtils.isEmpty(map.get("softVersion"))?null:map.get("softVersion").toString());
    linkOs.setDloPatchversion(ObjectUtils.isEmpty(map.get("patchVersion"))?null:map.get("patchVersion").toString());
    linkOs.setDloCreatetime(new Date());
    return linkOs;
  }
}
