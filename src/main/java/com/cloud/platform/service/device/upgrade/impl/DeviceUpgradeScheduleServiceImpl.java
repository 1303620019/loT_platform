package com.cloud.platform.service.device.upgrade.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.upgrade.DeviceUpgradeSchedule;
import com.cloud.platform.mapper.device.upgrade.DeviceUpgradeScheduleMapper;
import com.cloud.platform.req.DeviceUpgradeScheduleREQ;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeScheduleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 升级进度表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-21
 */
@Service
public class DeviceUpgradeScheduleServiceImpl
        extends ServiceImpl<DeviceUpgradeScheduleMapper, DeviceUpgradeSchedule> implements IDeviceUpgradeScheduleService {

  @Override
  public ResultVo search(DeviceUpgradeScheduleREQ req) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("dus_jobId",req.getJobId());
    wrapper.orderByDesc("dus_createTime");
    IPage<DeviceUpgradeSchedule> ScheduleList = baseMapper.selectPage(req.getPage(), wrapper);
    return ResultVo.ok(ScheduleList.getRecords(),ScheduleList.getTotal());
  }
}
