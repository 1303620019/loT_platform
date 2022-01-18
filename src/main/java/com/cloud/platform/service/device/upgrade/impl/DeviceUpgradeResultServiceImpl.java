package com.cloud.platform.service.device.upgrade.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;
import com.cloud.platform.entity.device.upgrade.DeviceUpgradeResult;
import com.cloud.platform.mapper.device.upgrade.DeviceUpgradeResultMapper;

import com.cloud.platform.service.device.IDeviceLinkOsService;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeResultService;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 设备升级结果 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-14
 */
@Service
public class DeviceUpgradeResultServiceImpl
        extends ServiceImpl<DeviceUpgradeResultMapper, DeviceUpgradeResult> implements IDeviceUpgradeResultService {
  @Autowired
  private IDeviceLinkOsService osService;
  @Autowired
  private IDeviceUpgradeService upgradeService;
  @Override
  public Boolean saveUpgradeResult(Map map) {
    DeviceUpgradeResult upgradeResult =new DeviceUpgradeResult();
    upgradeResult.setJobId(ObjectUtils.isEmpty(map.get("jobId"))?null:Integer.parseInt(map.get("jobId").toString()));
    upgradeResult.setCode(ObjectUtils.isEmpty(map.get("code"))?null:map.get("code").toString());
    upgradeResult.setMsg(ObjectUtils.isEmpty(map.get("msg"))?null:map.get("msg").toString());
    upgradeResult.setDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
    upgradeResult.setCreateTime(new Date());
      if (!ObjectUtils.isEmpty(upgradeResult)){
        baseMapper.insert(upgradeResult);
      }

    if (!ObjectUtils.isEmpty(map.get("code"))  && "200".equals(map.get("code").toString())){
      DeviceUpgrade upgrade = upgradeService.selectByJobId(map.get("jobId").toString());
     // osService.updateByDeviceId(map.get("deviceId").toString(),upgrade.getVersion());
    }

    return true;
  }



}
