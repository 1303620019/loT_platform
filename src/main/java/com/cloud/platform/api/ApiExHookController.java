package com.cloud.platform.api;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description: EMQ X 钩子
 * @author zlk
 * @date 2021-12-28 11:54
 * @version 1.0
*/
@RestController
@RequestMapping("/mqtt")
public class ApiExHookController {

	/**
	 * @description:
	 * @param:
 * @param map  参考 https://docs.emqx.cn/broker/v4.3/advanced/hooks.html
	 *             https://docs.emqx.cn/broker/v4.3/advanced/webhook.html#webhook-%E4%BA%8B%E4%BB%B6%E5%8F%82%E6%95%B0
	各种钩子函数
	client_connect | client_connack| client_connected  客户端连接函数
	| client_disconnected  客户端退出| client_authenticate  客户端认证次数
	| client_check_acl  ACL 规则检查次数| client_subscribe   客户端订阅次数
	| client_unsubscribe 客户端取消订阅次数| session_created    创建的会话数量
	| session_subscribed| session_unsubscribed
	| session_resumed| session_discarded
	| session_takeovered| session_terminated
	| message_publish 	除系统消息外发布的消息| message_delivered  内部转发到订阅进程的消息
	| message_acked| message_dropped.
	 * @return: void
	 * @author zlk
	 * @date: 2021-12-28 11:58
	 */
	@RequestMapping("/webhook")
	public void hook(@RequestBody Map<String, Object> map){
		//下边只是监听常见的函数
		String action = (String) map.get("action");
		String clientid = (String) map.get("clientid");
		if (action.equals("client_connected")) {
			System.out.println("客户端"+clientid+"已连接");
		}else if (action.equals("client_disconnected")) {
			System.out.println("客户端"+clientid+"已断开");
		}else if (action.equals("message_publish")){
			System.out.println("发送消息");
		}else if(action.equals("message_delivered")){
			System.out.println("接收订阅主题中的消息");
		}else if(action.equals("message_acked")){
			System.out.println("收到告知");
		}else if(action.equals("message_dropped")){
			System.out.println("意外断开"+map.toString());
		}else if(action.equals("client_subscribe")){
			System.out.println("客户端进行订阅"+map.toString());
		}else if (action.equals("client_unsubscribe")){
			System.out.println("客户端取消订阅"+map.toString());
		}
	}
}
