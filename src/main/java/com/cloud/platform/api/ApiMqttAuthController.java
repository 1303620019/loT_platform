package com.cloud.platform.api;

import com.cloud.platform.req.AuthenticationREQ;
import com.cloud.platform.service.IEquipmentAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zlk
 * @version 1.0
 * @description: 登录、授权
 * @date 2021-12-27 18:51
 */
@Api(value = "mqtt授权",description = "mqtt登录，授权")
@RestController
@RequestMapping("/mqtt")
public class ApiMqttAuthController {

	@Resource
	private IEquipmentAuthService equipmentAuthService;

	/**
	 * @param access username clientid topic mountpoint
	 * @description: 登录
	 * @param:
	 * @return: org.springframework.http.ResponseEntity 返回值
	 * @author zlk
	 * @date: 2021-12-27 18:54
	 */
	@ApiOperation("登录认证接口")
	@PostMapping("/auth")
	public ResponseEntity auth(AuthenticationREQ req) {

		if (ObjectUtils.isEmpty(req)){
			// 返回4xx时，认为时登录失败
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		//登录授权认证
		Boolean aBoolean = equipmentAuthService.authenticationConnect(req);
		if ( aBoolean ) {
			// 返回200时，emqx认为是登录成功
			return new ResponseEntity(HttpStatus.OK);
		}
		// 返回4xx时，认为时登录失败
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}

	/**
	 * @param clientid 客户端id
	 * @param username 用户名
	 * @description: 超级用户登录发布ACL 授权原理
	 * @param:
	 * @return: org.springframework.http.ResponseEntity<?>
	 * @author zlk
	 * @date: 2021-12-27 19:00
	 */
	@ApiOperation("超级用户（订阅,发布)")
	@GetMapping("/superuser")
	public ResponseEntity superUser(AuthenticationREQ  req) {
		if (req.getUsername().contains("admin")) {
			//是超级用户
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}

	/**
	 * @description: 用户登录后进行发布订阅 （ACL 授权原理）
	 * @param:
	 * @return: org.springframework.http.ResponseEntity
	 * @author zlk
	 * @date: 2021-12-27 19:01
	 */
	@GetMapping("/acl")
	public ResponseEntity acl(AuthenticationREQ req) {

		return new ResponseEntity(HttpStatus.OK);
	}
}
