package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
import com.cloud.platform.entity.device.function.DeviceFunctionMem;
import com.cloud.platform.mapper.device.function.DeviceFunctionInfoMapper;
import com.cloud.platform.service.device.function.IDeviceFunctionInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 设备运行状态 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Service
public class DeviceFunctionInfoServiceImpl extends ServiceImpl<DeviceFunctionInfoMapper, DeviceFunctionInfo>
        implements IDeviceFunctionInfoService {

  @Override
  public String saveFunctionInfo(Map map) {
    DeviceFunctionInfo functionInfo = crateFunctionInfo(map);
    int insert = baseMapper.insert(functionInfo);
    return functionInfo.getId();
  }

    public  DeviceFunctionInfo  crateFunctionInfo(Map map){
      DeviceFunctionInfo functionInfo = new DeviceFunctionInfo();
      functionInfo.setCpuRate(ObjectUtils.isEmpty(map.get("cpuRate"))?null:Integer.parseInt(map.get("cpuRate").toString()));
      functionInfo.setDfmId(ObjectUtils.isEmpty(map.get("memUsed"))?null:map.get("memUsed").toString());
      functionInfo.setDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
      functionInfo.setDiskUsed(ObjectUtils.isEmpty(map.get("diskUsed"))?null:Integer.parseInt(map.get("diskUsed").toString()));
      functionInfo.setTempValue(ObjectUtils.isEmpty(map.get("tempValue"))?null:Integer.parseInt(map.get("tempValue").toString()));
      functionInfo.setDevDateTime(ObjectUtils.isEmpty(map.get("devDateTime"))?null:map.get("devDateTime").toString());
      functionInfo.setDevStDateTime(ObjectUtils.isEmpty(map.get("devStDateTime"))?null:map.get("devStDateTime").toString());
      functionInfo.setDevRunTime(ObjectUtils.isEmpty(map.get("devRunTime"))?null:Integer.parseInt(map.get("devRunTime").toString()));
      functionInfo.setLatitude(ObjectUtils.isEmpty(map.get("longitude"))?null:map.get("longitude").toString());
      functionInfo.setLongitude(ObjectUtils.isEmpty(map.get("latitude"))?null:map.get("latitude").toString());
      functionInfo.setCreateTime(new Date());
      return functionInfo;
    }
}
