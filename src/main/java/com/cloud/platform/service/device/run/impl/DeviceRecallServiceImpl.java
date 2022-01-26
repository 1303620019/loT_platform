package com.cloud.platform.service.device.run.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.run.DeviceRecall;
import com.cloud.platform.mapper.device.run.DeviceRecallMapper;
import com.cloud.platform.service.device.run.IDeviceRecallService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 召回类型列表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Service
public class DeviceRecallServiceImpl
        extends ServiceImpl<DeviceRecallMapper, DeviceRecall> implements IDeviceRecallService {


  @Override
  public List<DeviceRecall> getList(List<String> recalls) {
    String recallstr = recalls.stream().map(s -> "\'" + s + "\'").collect(Collectors.joining(", "));
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.inSql("dr_id", recallstr);
    List<DeviceRecall> list = baseMapper.selectList(wrapper);
    return list;
  }



}
