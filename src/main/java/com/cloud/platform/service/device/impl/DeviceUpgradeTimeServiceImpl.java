package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceUpgradeTime;
import com.cloud.platform.mapper.device.DeviceUpgradeTimeMapper;
import com.cloud.platform.service.device.IDeviceUpgradeTimeService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 时间同步记录 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-22
 */
@Service
public class DeviceUpgradeTimeServiceImpl
        extends ServiceImpl<DeviceUpgradeTimeMapper, DeviceUpgradeTime> implements IDeviceUpgradeTimeService {

  @Override
  public Integer getMid() {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.orderByDesc("dut_dusCreateTime");
    wrapper.last(" limit 1");
    DeviceUpgradeTime time = baseMapper.selectOne(wrapper);
    if (!ObjectUtils.isEmpty(time)){
      return time.getDutMid();
    }
    return 1;
  }
}
