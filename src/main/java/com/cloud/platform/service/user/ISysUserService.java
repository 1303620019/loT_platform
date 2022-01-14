package com.cloud.platform.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.platform.entity.user.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
public interface ISysUserService extends IService<SysUser> {

  SysUser getUser(String userName,String password);

}
