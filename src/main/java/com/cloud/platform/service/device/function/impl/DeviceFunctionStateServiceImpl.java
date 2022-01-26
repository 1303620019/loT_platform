package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkDev;
import com.cloud.platform.entity.device.DeviceLinkLinks;
import com.cloud.platform.entity.device.function.DeviceFunctionState;
import com.cloud.platform.mapper.device.function.DeviceFunctionStateMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.service.device.function.IDeviceFunctionStateService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 接口运行状态 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Service
public class DeviceFunctionStateServiceImpl
        extends ServiceImpl<DeviceFunctionStateMapper, DeviceFunctionState>
        implements IDeviceFunctionStateService {



  @Override
  public Boolean saveFunctionState(Map map) {
    if (!ObjectUtils.isEmpty(map.get("linkState"))) {
      List<DeviceFunctionState> functionMem = createFunctionMem(map);
      baseMapper.insertArrayStates(functionMem);
    }
    return true;
  }


  public List<DeviceFunctionState> createFunctionMem(Map map){
    List<DeviceFunctionState> list =new ArrayList<>();
    Object states =map.get("linkState");
    JSONArray jsonArray = JSONArray.parseArray(states.toString());
    for(int i = 0; i < jsonArray.size(); i++) {
      JSONObject obj = jsonArray.getJSONObject(i);
      DeviceFunctionState deviceFunctionState = new DeviceFunctionState();
      deviceFunctionState.setDfiId(ObjectUtils.isEmpty(map.get("infoId"))?null:map.get("infoId").toString());
      deviceFunctionState.setName(obj.getString("name"));
      deviceFunctionState.setStatus(obj.getString("status"));
      deviceFunctionState.setCreateTime(new Date());
      list.add(deviceFunctionState);
    }
    return list;
  }

  @Override
  public ResultVo getStateList(DeviceLinkDevREQ req) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("dfs_dfiId",req.getDfiId());
    wrapper.orderByDesc("dfs_createTime");
    IPage<DeviceFunctionState> page=new Page<DeviceFunctionState>();
    IPage<DeviceLinkDev> page1 = req.getPage();
    page.setCurrent(page1.getCurrent());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceLinkLinks> linksIPage = baseMapper.selectPage(page, wrapper);
    return ResultVo.ok(linksIPage.getRecords(),linksIPage.getTotal());
  }
}
