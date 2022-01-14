package com.cloud.platform.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.EquipmentAuth;
import com.cloud.platform.req.AuthenticationREQ;

/**
 * <p>
 * 登录认证表 服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
public interface IEquipmentAuthService extends IService<EquipmentAuth> {

 /**
 * 功能描述: <br>
 * 〈客户端登录认证〉
 * @Param: [req]
 * @Return: java.lang.Boolean
 * @Author: byl
 * @Date:  
 */
  Boolean authenticationConnect(AuthenticationREQ req);
}
