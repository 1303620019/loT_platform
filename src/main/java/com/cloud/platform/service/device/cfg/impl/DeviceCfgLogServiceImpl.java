package com.cloud.platform.service.device.cfg.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.cfg.DeviceCfgLog;
import com.cloud.platform.mapper.device.cfg.DeviceCfgLogMapper;
import com.cloud.platform.req.DeviceCfgLogREQ;
import com.cloud.platform.service.device.cfg.IDeviceCfgLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 配置管理记录 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-17
 */
@Service
public class DeviceCfgLogServiceImpl
        extends ServiceImpl<DeviceCfgLogMapper, DeviceCfgLog> implements IDeviceCfgLogService {

  @Resource
  private DeviceCfgLogMapper cfgLogMapper;
  @Override
  public ResultVo search(DeviceCfgLogREQ req) {
    QueryWrapper wrapper =new QueryWrapper();
    wrapper.eq("dc_deviceId",req.getDeviceId());
    wrapper.orderByDesc("dc_createTime");
    IPage<DeviceCfgLog> cfgLogs = baseMapper.selectPage(req.getPage(), wrapper);
    return ResultVo.ok(cfgLogs.getRecords(),cfgLogs.getTotal());
  }

  @Override
  public Result   del(String id) {
    cfgLogMapper.del(id);
    return Result.ok();
  }
}
