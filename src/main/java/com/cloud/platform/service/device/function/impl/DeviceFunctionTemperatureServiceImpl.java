package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.function.DeviceFunctionMem;
import com.cloud.platform.entity.device.function.DeviceFunctionTemperature;
import com.cloud.platform.mapper.device.function.DeviceFunctionTemperatureMapper;
import com.cloud.platform.service.device.function.IDeviceFunctionTemperatureService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 主动上报的上报时间间隔 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Service
public class DeviceFunctionTemperatureServiceImpl extends ServiceImpl<DeviceFunctionTemperatureMapper,
        DeviceFunctionTemperature>implements IDeviceFunctionTemperatureService {

  @Override
  public Boolean saveTemperature(Map map) {
    if (!ObjectUtils.isEmpty(map.get("temperature"))) {
      DeviceFunctionTemperature temperature = JSON.parseObject(map.get("temperature").toString(), DeviceFunctionTemperature.class);
      temperature.setDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
      temperature.setDevId(ObjectUtils.isEmpty(map.get("dliId"))?null:map.get("dliId").toString());
      temperature.setCreateTime(new Date());
      int insert = baseMapper.insert(temperature);
    }
    return true;
  }


  public DeviceFunctionTemperature createTemperature(Map map){
    DeviceFunctionTemperature deviceFunctionTemperature = new DeviceFunctionTemperature();



    return deviceFunctionTemperature;
  }
}
