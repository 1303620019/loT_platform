package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkCpu;
import com.cloud.platform.mapper.device.DeviceLinkCpuMapper;
import com.cloud.platform.service.device.IDeviceLinkCpuService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 表Cpu 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkCpuServiceImpl extends ServiceImpl<DeviceLinkCpuMapper, DeviceLinkCpu> implements IDeviceLinkCpuService {

  @Override
  public Boolean saveLinkCpu(Map map) {
    if (!ObjectUtils.isEmpty(map.get("cpu"))) {
      Map<String, Object> cpu = JSON.parseObject(map.get("cpu").toString(), Map.class);
      DeviceLinkCpu linkCpu = createLinkCpu(cpu);
      linkCpu.setDldDliId(map.get("dliId").toString());
      int insert = baseMapper.insert(linkCpu);
    }
    return true;
  }



  public DeviceLinkCpu  createLinkCpu(Map map){
    DeviceLinkCpu linkCpu=new DeviceLinkCpu();
    linkCpu.setDlcCpus(ObjectUtils.isEmpty(map.get("cpus"))?null:Integer.parseInt(map.get("cpus").toString()));
    linkCpu.setDlcFrequency(ObjectUtils.isEmpty(map.get("frequency"))?null:map.get("frequency").toString());
    linkCpu.setDlcArch(ObjectUtils.isEmpty(map.get("arch"))?null:map.get("arch").toString());
    linkCpu.setDlcCache(ObjectUtils.isEmpty(map.get("cache"))?null:Integer.parseInt(map.get("cache").toString()));
    linkCpu.setDlcCpulmt(ObjectUtils.isEmpty(map.get("cpuLmt"))?null:Integer.parseInt(map.get("cpuLmt").toString()));
    linkCpu.setDlcCreatetime(new Date());
    return linkCpu;
  }
}
