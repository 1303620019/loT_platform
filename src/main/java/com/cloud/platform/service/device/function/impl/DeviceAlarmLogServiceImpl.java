package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.function.DeviceAlarmLog;
import com.cloud.platform.entity.device.function.DeviceFunctionRepperiod;
import com.cloud.platform.mapper.device.function.DeviceAlarmLogMapper;
import com.cloud.platform.service.device.function.IDeviceAlarmLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 设备告警事件 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Service
public class DeviceAlarmLogServiceImpl
        extends ServiceImpl<DeviceAlarmLogMapper, DeviceAlarmLog> implements IDeviceAlarmLogService {

  @Override
  public Boolean saveAlarmLog(Map map) {
      DeviceAlarmLog alarmLog=new DeviceAlarmLog();
      alarmLog.setEvent(ObjectUtils.isEmpty(map.get("event")) ? null : map.get("event").toString());
      alarmLog.setMsg(ObjectUtils.isEmpty(map.get("msg")) ? null : map.get("msg").toString());
      alarmLog.setDeviceId(ObjectUtils.isEmpty(map.get("deviceId")) ? null : map.get("deviceId").toString());
      alarmLog.setCreateTime(new Date());
      if (!ObjectUtils.isEmpty(alarmLog)){
        baseMapper.insert(alarmLog);
      }

    return true;
  }
}
