package com.cloud.platform.service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.platform.base.Result;

import java.io.IOException;

/**
 * @description: EMQ X 提供了 HTTP API 以实现与外部系统的集成
 * @url https://docs.emqx.cn/broker/v4.1/advanced/http-api.html#%E6%8E%A5%E5%8F%A3%E5%AE%89%E5%85%A8
 * @projectName:loT_platform
 * @see:com.cloud.platform.service
 * @author:byl
 * @createTime:2022/1/7 17:08
 * @version:1.0
 */
public interface IMqttHttpPort {

   Result findBrokers()throws IOException;
   Result findClients(String page, String limit)throws IOException;

   Boolean  sendMsg(Object data,Object param,String label);
   Boolean  sendMsg(Object data,String topic);
}
