package com.cloud.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.platform.comm.Result;
import com.cloud.platform.config.MqttInfoConfig;
import com.cloud.platform.entity.device.DeviceMessageLog;
import com.cloud.platform.req.MessageHeadREQ;
import com.cloud.platform.service.IMqttHttpPort;
import com.cloud.platform.tools.MQTTClient;
import com.cloud.platform.util.SimpleHttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description: 访问mqtt api
 * @projectName:loT_platform
 * @see:com.cloud.platform.service.impl
 * @author:byl
 * @createTime:2022/1/7 17:09
 * @version:1.0
 */
@Slf4j
@Service
public class IMqttHttpPortImpl implements IMqttHttpPort {
  @Autowired
  private MqttInfoConfig mqttInfoConfig;

  /**
   * 功能描述: <br>
   * 〈集群下所有节点的基本信息〉
   *
   * @Param:
   * @Return:
   * @Author: byl
   * @Date:
   */
  public Result findBrokers() throws IOException {
    Map<String, String> paramsMap = new HashMap<>();
    HttpResponse httpResponse = SimpleHttpClientUtil.doGet(mqttInfoConfig.getHost() + ":" + mqttInfoConfig.getPort() + "/api/v4/brokers/" + "emqx@" + mqttInfoConfig.getHost());
    log.info("返回参数" + EntityUtils.toString(httpResponse.getEntity()));
    return Result.ok(EntityUtils.toString(httpResponse.getEntity()));
  }

  @Override
  public Result findClients(String _page, String _limit) throws IOException {
    Map<String, String> paramsMap = new HashMap<>();
    paramsMap.put("_page", _page);
    paramsMap.put("_limit", _limit);
    HttpResponse httpResponse = SimpleHttpClientUtil.doGet(mqttInfoConfig.getHost(), mqttInfoConfig.getPort() + "/api/v4/clients", paramsMap);
    HttpEntity entity = httpResponse.getEntity();
    if (entity != null) {
      log.info("响应内容为:" + entity.getContentLength());
      String jsonString = EntityUtils.toString(httpResponse.getEntity()).toString();
      log.info("响应内容为:" + jsonString);
      return Result.ok(JSONObject.parseObject(jsonString));
    }

    return null;
  }

  @Override
  public Boolean sendMsg(Object data, Object param,String label) {
    try {
      MQTTClient client = new MQTTClient();
      client.connect("admin", "tszh@tcm512.com");
      DeviceMessageLog messageLogData = (DeviceMessageLog) data;
      String topic = messageLogData.getDmlTopic();
      String dmlPayload = messageLogData.getDmlPayload();
      MessageHeadREQ messageHeadREQ = JSON.parseObject(dmlPayload, MessageHeadREQ.class);
      messageHeadREQ.setParam(param);
      messageHeadREQ.setTimestamp(new Date() + "");
      messageHeadREQ.setCode(200);
      String replaceTopic = topic.replace("request", label);
      client.subscribe(replaceTopic,2);

      //向主题发布消息
      new Thread(() -> {
        client.publish(replaceTopic, JSONArray.toJSON(messageHeadREQ).toString(), 2, false);
        try {
          TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    } catch (Exception e) {
      log.error("平台发送消息报错:{} ", e.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public Boolean sendMsg(Object data,String topic) {
    try {
      MQTTClient client = new MQTTClient();
      client.connect("admin", "tszh@tcm512.com");
      client.subscribe(topic,2);
      client.publish(topic,JSON.toJSONString(data), 2, false);
//      //向主题发布消息
//      new Thread(() -> {
//
//        try {
//          TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }).start();
    } catch (Exception e) {
      log.error("平台发送消息报错:{} ", e.getMessage());
      return false;
    }
    return true;
  }
}
