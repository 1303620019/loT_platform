package com.cloud.platform.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.platform.entity.EquipmentAuth;
import com.cloud.platform.req.AuthenticationREQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 登录认证表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Mapper
public interface EquipmentAuthMapper extends BaseMapper<EquipmentAuth> {

  EquipmentAuth authenticationConnect(@Param("req") AuthenticationREQ req);
}
