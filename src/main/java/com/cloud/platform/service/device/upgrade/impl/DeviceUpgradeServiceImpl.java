package com.cloud.platform.service.device.upgrade.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;

import com.cloud.platform.mapper.device.upgrade.DeviceUpgradeMapper;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 文件信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Service
public class DeviceUpgradeServiceImpl extends ServiceImpl<DeviceUpgradeMapper, DeviceUpgrade>
             implements IDeviceUpgradeService {

  @Override
  public Boolean updateUpgrade(String deviceId, Map map) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("du_dldId",deviceId);
    wrapper.eq("du_jobId", ObjectUtils.isEmpty(map.get("jobId"))?null:Integer.parseInt(map.get("jobId").toString()));
    wrapper.last(" limit 1");
    DeviceUpgrade deviceUpgrade = baseMapper.selectOne(wrapper);
    if (ObjectUtils.isNotEmpty(deviceUpgrade)){
      deviceUpgrade.setProgress(ObjectUtils.isEmpty(map.get("progress"))?null:Integer.parseInt(map.get("progress").toString()));
      deviceUpgrade.setState(ObjectUtils.isEmpty(map.get("state"))?null:Integer.parseInt(map.get("state").toString()));
      deviceUpgrade.setCreateTime(new Date());
    }
    baseMapper.updateById(deviceUpgrade);
    return true;
  }

  @Override
  public DeviceUpgrade selectByJobId(String jobId) {

    QueryWrapper wrapper =new QueryWrapper();
    wrapper.eq("du_jobId",jobId);
    DeviceUpgrade deviceUpgrade = baseMapper.selectOne(wrapper);
    return deviceUpgrade;
  }
}
