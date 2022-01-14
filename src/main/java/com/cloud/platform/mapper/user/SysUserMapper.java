package com.cloud.platform.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.platform.entity.user.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Mapper
public interface   SysUserMapper extends BaseMapper<SysUser> {
   SysUser getUser(@Param("userName") String userName, @Param("password")String password);
}
