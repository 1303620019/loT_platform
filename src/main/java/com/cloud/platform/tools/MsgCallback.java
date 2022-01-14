package com.cloud.platform.tools;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @description: 消息订阅的回调
 * @author zlk
 * @date 2021-12-28 11:30
 * @version 1.0
*/
public class MsgCallback implements MqttCallback {
	@Override
	public void connectionLost(Throwable throwable) {
		// 丢失连接的处理
	}

	/**
	 * @description:  消息到达的处理
	 * @param:
	 * @param s 主题
	 * @param mqttMessage 消息内容
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:30
	 */
	@Override
	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
		System.out.println("消息主题："+s+",消息id："+mqttMessage.getId()+",消息质量："+mqttMessage.getQos()+",消息内容"+new String(mqttMessage.getPayload()));
	}

	/** 
	 * @description: 消息发布成功，并且已经收到了确认回复 
	 * @param: 
 * @param iMqttDeliveryToken  
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:35
	 */ 
	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
		System.out.println("消息id："+iMqttDeliveryToken.getMessageId()+"，主题："+iMqttDeliveryToken.getTopics());
	}
}
