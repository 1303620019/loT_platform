package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.entity.device.DeviceLinkLinks;
import com.cloud.platform.entity.device.function.DeviceFunctionAiapp;
import com.cloud.platform.mapper.device.function.DeviceFunctionAiappMapper;
import com.cloud.platform.service.device.function.IDeviceFunctionAiappService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Ai运行信息 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Service
public class DeviceFunctionAiappServiceImpl
        extends ServiceImpl<DeviceFunctionAiappMapper, DeviceFunctionAiapp> implements IDeviceFunctionAiappService {


  @Override
  public Boolean saveFunctionAiapp(Map map) {
    if (!ObjectUtils.isEmpty(map.get("aiApp"))) {
      List<DeviceFunctionAiapp> Aiapps = createFunctionAiapp(map);
      baseMapper.insertArrayAiapp(Aiapps);
    }

    return null;
  }

  public List<DeviceFunctionAiapp> createFunctionAiapp(Map map) {
    List<DeviceFunctionAiapp> list = new ArrayList<>();
    Object links = map.get("aiApp");
    JSONArray objects = JSONArray.parseArray(links.toString());
    for (int i = 0; i < objects.size(); i++) {
      JSONObject obj = objects.getJSONObject(i);
      DeviceFunctionAiapp aiapp = new DeviceFunctionAiapp();
      aiapp.setDfaDeviceid(ObjectUtils.isEmpty(map.get("deviceId")) ? null : map.get("deviceId").toString());
      aiapp.setDfaDeviceid(ObjectUtils.isEmpty(obj.get("info")) ? null : obj.get("info").toString());
      aiapp.setDfaDfiId(ObjectUtils.isEmpty(map.get("infoId")) ? null : map.get("infoId").toString());
      aiapp.setDfaCreatetime(new Date());
      list.add(aiapp);
    }
    return list;
  }
}