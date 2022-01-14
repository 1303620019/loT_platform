package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.base.Result;
import com.cloud.platform.entity.device.DeviceMessageLog;
import com.cloud.platform.mapper.device.DeviceMessageLogMapper;
import com.cloud.platform.service.device.IDeviceMessageLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 消息记录 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Slf4j
@Service
public class DeviceMessageLogServiceImpl extends ServiceImpl<DeviceMessageLogMapper, DeviceMessageLog>
        implements IDeviceMessageLogService {

  @Override
  public Result saveMessage(Map<String, Object> map) {
    DeviceMessageLog message = createMessage(map);
    int insert = baseMapper.insert(message);
    return Result.ok(message);
  }



  public DeviceMessageLog  createMessage(Map map){
    DeviceMessageLog messageLog=new DeviceMessageLog();
    messageLog.setDmlUsername(ObjectUtils.isEmpty(map.get("username"))?null:map.get("username").toString());
    messageLog.setDmlClientid(ObjectUtils.isEmpty(map.get("clientid"))?null:map.get("clientid").toString());
    messageLog.setDmlPayload(ObjectUtils.isEmpty(map.get("payload"))?null:map.get("payload").toString());
    messageLog.setDmlPeerhost(ObjectUtils.isEmpty(map.get("peerhost"))?null:map.get("peerhost").toString());
    messageLog.setDmlTopic(ObjectUtils.isEmpty(map.get("topic"))?null:map.get("topic").toString());
    messageLog.setDmlQos(ObjectUtils.isEmpty(map.get("qos"))?null:map.get("qos").toString());
    messageLog.setDmlTimestamp(ObjectUtils.isEmpty(map.get("timestamp"))?null:map.get("timestamp").toString());
    messageLog.setDmlPublishReceivedAt(ObjectUtils.isEmpty(map.get("publish_received_at"))
                                        ?null:map.get("publish_received_at").toString());
    messageLog.setDmlNode(ObjectUtils.isEmpty(map.get("node"))?null:map.get("node").toString());
    messageLog.setCreateTime(new Date());
    return messageLog;
  }
}
