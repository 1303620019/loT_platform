package com.cloud.platform.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.EquipmentAuth;
import com.cloud.platform.mapper.EquipmentAuthMapper;
import com.cloud.platform.req.AuthenticationREQ;
import com.cloud.platform.service.IEquipmentAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 登录认证表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Service
public class EquipmentAuthServiceImpl extends ServiceImpl<EquipmentAuthMapper, EquipmentAuth> implements IEquipmentAuthService {
  @Resource
  private EquipmentAuthMapper equipmentAuthMapper;

  @Override
  public Boolean authenticationConnect(AuthenticationREQ req) {
    EquipmentAuth equipmentAuthIPage = equipmentAuthMapper.authenticationConnect(req);
    if (ObjectUtils.isEmpty(equipmentAuthIPage)) {
      return false;
    }
    return true;
  }
}
