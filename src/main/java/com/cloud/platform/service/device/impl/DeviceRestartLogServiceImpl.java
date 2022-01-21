package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.DeviceRestartLog;
import com.cloud.platform.mapper.device.DeviceRestartLogMapper;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DeviceRestartLogREQ;
import com.cloud.platform.service.device.IDeviceRestartLogService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 设备重启记录 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Service
public class DeviceRestartLogServiceImpl
        extends ServiceImpl<DeviceRestartLogMapper, DeviceRestartLog> implements IDeviceRestartLogService {

  @Override
  public Integer saveLog(DeviceRestartLog restartLog) {
    int insert = baseMapper.insert(restartLog);
    return insert;
  }

  @Override
  public Boolean editLog(String deviceId, String code) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("drl_deviceId",deviceId);
    wrapper.orderByDesc("drl_createTime");
    if(!StringUtils.isBlank(deviceId)){
      DeviceRestartLog deviceRestartLog = baseMapper.selectOne(wrapper);
      deviceRestartLog.setResultCode(code);
      deviceRestartLog.setResultState(0);
      deviceRestartLog.setResultTime(new Date());
      baseMapper.updateById(deviceRestartLog);
      return true;

    }
    return false;
  }

  @Override
  public ResultVo search(DeviceRestartLogREQ req) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("drl_deviceId",req.getDeviceId());
    wrapper.orderByDesc("drl_result_time");
    IPage<DeviceRestartLog> logIPage = baseMapper.selectPage(req.getPage(), wrapper);

    return ResultVo.ok(logIPage.getRecords(),logIPage.getTotal());
  }
}
