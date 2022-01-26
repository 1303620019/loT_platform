package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkDev;
import com.cloud.platform.entity.device.function.DeviceFunctionAiapp;
import com.cloud.platform.mapper.device.function.DeviceFunctionAiappMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
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
  public Boolean  saveFunctionAiapp(Map map) {
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
      String obj = objects.getString(i);
      String[] split = obj.split(",");
      DeviceFunctionAiapp aiapp = new DeviceFunctionAiapp();
      aiapp.setDfaDeviceid(ObjectUtils.isEmpty(map.get("deviceId")) ? null : map.get("deviceId").toString());
      aiapp.setAiName(ObjectUtils.isEmpty(split) ? null : split[0]);
      aiapp.setDfaVersions(ObjectUtils.isEmpty(split) ? null : split[1]);
      aiapp.setDfaDfiId(ObjectUtils.isEmpty(map.get("infoId")) ? null : map.get("infoId").toString());
      aiapp.setDfaCreatetime(new Date());
      list.add(aiapp);
    }
    return list;
  }

  @Override
  public ResultVo getAppList(DeviceLinkDevREQ req) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("dfa_dfiId",req.getDfiId());
    wrapper.orderByDesc("dfa_createTime");
    IPage<DeviceFunctionAiapp> page=new Page<DeviceFunctionAiapp>();
    IPage<DeviceLinkDev> page1 = req.getPage();
    page.setCurrent(page1.getCurrent());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceFunctionAiapp> AppList = baseMapper.selectPage(page, wrapper);
    return ResultVo.ok(AppList.getRecords(),AppList.getTotal());
  }
}