package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkAi;
import com.cloud.platform.entity.device.DeviceLinkMem;
import com.cloud.platform.mapper.device.DeviceLinkAiMapper;
import com.cloud.platform.service.device.IDeviceLinkAiService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * AI模块信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-17
 */
@Service
public class DeviceLinkAiServiceImpl
        extends ServiceImpl<DeviceLinkAiMapper, DeviceLinkAi> implements IDeviceLinkAiService {

  @Override
  public Boolean saveAi(Map map) {
    if (!ObjectUtils.isEmpty(map.get("ai"))) {
      Map<String, Object> mem = JSON.parseObject(map.get("ai").toString(), Map.class);
      DeviceLinkAi linkAi = createLinkAi(mem);
      linkAi.setDldId(map.get("dliId").toString());
      linkAi.setDeviceId(map.get("deviceId").toString());
      baseMapper.insert(linkAi);
    }
    return true;
  }


  public DeviceLinkAi createLinkAi(Map map){
    DeviceLinkAi linkAi=new DeviceLinkAi();
    linkAi.setModel(ObjectUtils.isEmpty(map.get("model"))?null:map.get("model").toString());
    linkAi.setOps(ObjectUtils.isEmpty(map.get("ops"))?null:Integer.parseInt(map.get("ops").toString()));
    linkAi.setCreateTime(new Date());
    return linkAi;
  }
}
