package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkLinks;
import com.cloud.platform.entity.device.function.DeviceFunctionMem;
import com.cloud.platform.mapper.device.function.DeviceFunctionMemMapper;
import com.cloud.platform.service.device.function.IDeviceFunctionMemService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 内存使用信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Service
public class DeviceFunctionMemServiceImpl extends ServiceImpl<DeviceFunctionMemMapper, DeviceFunctionMem>
        implements IDeviceFunctionMemService {
  @Override
  public String saveFunctionMen(Map map) {
    if (!ObjectUtils.isEmpty(map.get("memUsed"))) {
      DeviceFunctionMem memUsed = JSON.parseObject(map.get("memUsed").toString(), DeviceFunctionMem.class);
      memUsed.setCreateTime(new Date());
      int insert = baseMapper.insert(memUsed);
      return  memUsed.getId();
    }
    return null;
  }

}
