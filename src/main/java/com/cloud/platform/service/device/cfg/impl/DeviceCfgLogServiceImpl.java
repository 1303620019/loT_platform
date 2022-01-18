package com.cloud.platform.service.device.cfg.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.cfg.DeviceCfgLog;
import com.cloud.platform.mapper.device.cfg.DeviceCfgLogMapper;
import com.cloud.platform.service.device.cfg.IDeviceCfgLogService;
import org.springframework.stereotype.Service;

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

}
