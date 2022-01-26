package com.cloud.platform.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.Equipment;
import com.cloud.platform.entity.Tmid;
import com.cloud.platform.mapper.EquipmentMapper;
import com.cloud.platform.mapper.TmidMapper;
import com.cloud.platform.service.IEquipmentService;
import com.cloud.platform.service.TmidService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Service
public class TmidServiceImpl extends ServiceImpl<TmidMapper, Tmid> implements TmidService {


  @Override
  @Transactional
  public Integer getMid() {
    Integer num=1;
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.orderByDesc( "m_createTime");
    wrapper.last(" limit 1");
    Tmid tmid = baseMapper.selectOne(wrapper);
    if (!ObjectUtils.isEmpty(tmid)){
        saveMid();
      return tmid.getMid()+1;
    }

    return num;
  }

  public Boolean saveMid(){
    Tmid tmid=new Tmid();
    tmid.setCreateTime(new Date());
    int insert = baseMapper.insert(tmid);
    return true;
  }
}
