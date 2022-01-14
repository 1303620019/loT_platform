package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.function.DeviceFunctionRepperiod;
import com.cloud.platform.entity.device.function.DeviceFunctionTemperature;
import com.cloud.platform.mapper.device.function.DeviceFunctionRepperiodMapper;
import com.cloud.platform.service.device.function.IDeviceFunctionRepperiodService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 运行温度监控 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Service
public class DeviceFunctionRepperiodServiceImpl
        extends ServiceImpl<DeviceFunctionRepperiodMapper, DeviceFunctionRepperiod> implements IDeviceFunctionRepperiodService {

  @Override
  public Boolean saveRepperiod(Map map) {
    if (!ObjectUtils.isEmpty(map.get("repPeriod"))) {
      DeviceFunctionRepperiod repPeriod = JSON.parseObject(map.get("repPeriod").toString(), DeviceFunctionRepperiod.class);
      repPeriod.setDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
      repPeriod.setDevId(ObjectUtils.isEmpty(map.get("dliId"))?null:map.get("dliId").toString());
      repPeriod.setCreateTime(new Date());
      int insert = baseMapper.insert(repPeriod);
    }
    return true;
  }
}
