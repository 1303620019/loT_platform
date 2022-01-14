package com.cloud.platform.service.impl;


import com.cloud.platform.entity.Equipment;
import com.cloud.platform.mapper.EquipmentMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.service.IEquipmentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements IEquipmentService {

}
