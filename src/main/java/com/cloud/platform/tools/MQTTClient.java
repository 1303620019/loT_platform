package com.cloud.platform.tools;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @description: mqtt客户端工具类
 * @author zlk
 * @date 2021-12-28 11:23
 * @version 1.0
*/
public class MQTTClient {

	private IMqttClient mqttClient;
	private String brokerUrl="tcp://192.168.1.146:1883";
	//private String brokerUrl="tcp://47.95.124.126:1883";
	private String clientId="mqtt-platform";

	public MQTTClient() {
		MqttClientPersistence persistence = new MemoryPersistence();
		try {
			mqttClient = new MqttClient(brokerUrl, clientId, persistence);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description: 连接
	 * @param:
 * @param username 用户名
 * @param password 密码
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:25
	 */
	public void connect(String username, String password) {
		//创建MQTT连接选项对象
		MqttConnectOptions options = new MqttConnectOptions();
		//自动重连
		options.setAutomaticReconnect(false);
		options.setCleanSession(true);
		options.setUserName(username);
		options.setPassword(password.toCharArray());
		//设置mqtt消息回调
		MsgCallback msgCallback=new MsgCallback();
		mqttClient.setCallback(msgCallback);
		//连接broker
		try {
			mqttClient.connect(options);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description: 消息发布
	 * @param:
 * @param topic 主题
 * @param msg 消息内容
 * @param qos 消息质量
 * @param retain 是否保留消息
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:25
	 */
	public void publish(String topic, String msg, int qos, boolean retain) {
		MqttMessage message = new MqttMessage();
		message.setQos(qos);
		message.setRetained(retain);
		message.setPayload(msg.getBytes());
		if (mqttClient.isConnected()) {
			try {
				mqttClient.publish(topic, message);
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @description: 消息订阅
	 * @param:
 * @param topicFilter 订阅主题
 * @param qos  消息质量
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:26
	 */
	public void subscribe(String topicFilter, int qos) {
		try {
			mqttClient.subscribe(topicFilter, qos);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description: 重连
	 * @param:
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:27
	 */
	public void reconnect() {
		try {
			mqttClient.reconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description: 断开连接
	 * @param:
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:27
	 */
	public void disConnect() {
		try {
			mqttClient.disconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}


}
