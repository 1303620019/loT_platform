package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkMem;
import com.cloud.platform.mapper.device.DeviceLinkMemMapper;
import com.cloud.platform.service.device.IDeviceLinkMemService;
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
public class DeviceLinkMemServiceImpl extends ServiceImpl<DeviceLinkMemMapper, DeviceLinkMem>
        implements IDeviceLinkMemService {


  @Override
  public Boolean savelinkMem(Map<String, Object> map) {
    if (!ObjectUtils.isEmpty(map.get("mem"))) {
      Map<String, Object> mem = JSON.parseObject(map.get("mem").toString(), Map.class);
      DeviceLinkMem linkMem = createLinkMem(mem);
      linkMem.setDlmDliId(map.get("dliId").toString());
      baseMapper.insert(linkMem);
    }

    return true;
  }

  public  DeviceLinkMem createLinkMem(Map map){
    DeviceLinkMem linkMem=new DeviceLinkMem();
    linkMem.setDlmMemlmt(ObjectUtils.isEmpty(map.get("memLmt"))?null:Integer.parseInt(map.get("memLmt").toString()));
    linkMem.setDlmPhy(ObjectUtils.isEmpty(map.get("phy"))?null:Integer.parseInt(map.get("phy").toString()));
    linkMem.setDlmVirt(ObjectUtils.isEmpty(map.get("virt"))?null:Integer.parseInt(map.get("virt").toString()));
    linkMem.setDlmCreatetime(new Date());
    return linkMem;

  }

}
