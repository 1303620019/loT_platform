package com.cloud.platform.service.user.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.user.SysUser;
import com.cloud.platform.mapper.user.SysUserMapper;
import com.cloud.platform.service.user.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

  @Override
  public SysUser getUser(String userName, String password) {
    QueryWrapper wrapper=new QueryWrapper();
    // 分类名称、状态
    if( StringUtils.isNotEmpty(userName) ){
      wrapper.eq("username", userName);
    }
    if( StringUtils.isNotEmpty(password) ){
      wrapper.eq("password", password);
    }
     wrapper.orderByDesc("create_time");
     wrapper.last("limit 1");
    SysUser sysUser = baseMapper.selectOne(wrapper);
    return sysUser;
  }
}
