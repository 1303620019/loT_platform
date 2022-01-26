package com.cloud.platform.service.device.function.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceLinkInfo;
import com.cloud.platform.entity.device.function.DeviceFunctionAiapp;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
import com.cloud.platform.entity.device.function.DeviceFunctionMem;
import com.cloud.platform.mapper.device.function.DeviceFunctionInfoMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.req.FunctionREQ;
import com.cloud.platform.service.device.IDeviceLinkInfoService;
import com.cloud.platform.service.device.function.IDeviceFunctionAiappService;
import com.cloud.platform.service.device.function.IDeviceFunctionInfoService;
import com.cloud.platform.service.device.function.IDeviceFunctionMemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 设备运行状态 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Service
public class DeviceFunctionInfoServiceImpl extends ServiceImpl<DeviceFunctionInfoMapper, DeviceFunctionInfo>
        implements IDeviceFunctionInfoService {
  @Resource
  private DeviceFunctionInfoMapper functionInfoMapper;
  @Resource
  private IDeviceLinkInfoService linkInfoService;
  @Resource
  private IDeviceFunctionMemService   memService;
  @Resource
  private IDeviceFunctionAiappService aiAppService;

  @Override
  public String saveFunctionInfo(Map map) {
    DeviceFunctionInfo functionInfo = crateFunctionInfo(map);
    int insert = baseMapper.insert(functionInfo);
    return functionInfo.getDfiId();
  }

  public DeviceFunctionInfo crateFunctionInfo(Map map) {
    DeviceFunctionInfo functionInfo = new DeviceFunctionInfo();
    functionInfo.setDfiDliId(ObjectUtils.isEmpty(map.get("linkInfoId")) ? null : map.get("linkInfoId").toString());
    functionInfo.setCpuRate(ObjectUtils.isEmpty(map.get("cpuRate")) ? null : map.get("cpuRate").toString());
    functionInfo.setDfmId(ObjectUtils.isEmpty(map.get("memUsed")) ? null : map.get("memUsed").toString());
    functionInfo.setDeviceId(ObjectUtils.isEmpty(map.get("deviceId")) ? null : map.get("deviceId").toString());
    functionInfo.setDiskUsed(ObjectUtils.isEmpty(map.get("diskUsed")) ? null : map.get("diskUsed").toString());
    functionInfo.setTempValue(ObjectUtils.isEmpty(map.get("tempValue")) ? null : map.get("tempValue").toString());
    functionInfo.setDevDateTime(ObjectUtils.isEmpty(map.get("devDateTime")) ? null : map.get("devDateTime").toString());
    functionInfo.setDevStDateTime(ObjectUtils.isEmpty(map.get("devStDateTime")) ? null : map.get("devStDateTime").toString());
    functionInfo.setDevRunTime(ObjectUtils.isEmpty(map.get("devRunTime")) ? null : map.get("devRunTime").toString());
    functionInfo.setLatitude(ObjectUtils.isEmpty(map.get("longitude")) ? null : map.get("longitude").toString());
    functionInfo.setLongitude(ObjectUtils.isEmpty(map.get("latitude")) ? null : map.get("latitude").toString());
    functionInfo.setCreateTime(new Date());
    return functionInfo;
  }


  @Override
  public ResultVo search(FunctionREQ req) {
    IPage<DeviceFunctionInfo> page = new Page<DeviceFunctionInfo>();
    IPage<DeviceFunctionInfo> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceFunctionInfo> search = functionInfoMapper.search(page, req);
    return ResultVo.ok(search.getRecords(), search.getTotal());
  }

  @Override
  public ResultVo cfgSearch(FunctionREQ req) {
//    QueryWrapper wrapper=new QueryWrapper();
//    wrapper.eq("dfi_deviceId",req.getDeviceId());
//    wrapper.orderByDesc("dfi_createTime");
//    IPage<DeviceFunctionInfo> cfgSearch = baseMapper.selectPage(req.getPage(), wrapper);
    IPage<DeviceFunctionInfo> page = new Page<DeviceFunctionInfo>();
    IPage<DeviceFunctionInfo> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceFunctionInfo> cfgSearchResult = functionInfoMapper.cfgSearch(page, req);
    return ResultVo.ok(cfgSearchResult.getRecords(), cfgSearchResult.getTotal());
  }

  @Override
  public Result stateInfo(DeviceLinkDevREQ req) {
    QueryWrapper qw=new QueryWrapper();
    JSONObject jsonObject = null;
    String[] splitStr = req.getMids().split(",");
    String mid = splitStr[1]; //0下标代表基础信息
    req.setMids(mid);
    DeviceFunctionInfo funInfo=null;
    DeviceFunctionMem mem=null;
    DeviceFunctionAiapp aiApp=null;
    DeviceLinkInfo linkInfo = linkInfoService.getLinkInfo(req);
    if (!org.springframework.util.ObjectUtils.isEmpty(linkInfo)){
      jsonObject = new JSONObject();
      qw.eq("dfi_dliId",linkInfo.getDilId());
      qw.eq("dfi_deviceId",req.getDeviceId());
      qw.orderByDesc("dfi_createTime");
      qw.last(" limit 1");
      funInfo = baseMapper.selectOne(qw);
      jsonObject.put("funInfo",funInfo);
    }
    if (!org.springframework.util.ObjectUtils.isEmpty(funInfo)){
      qw=new QueryWrapper();
      qw.eq("dfm_id",funInfo.getDfmId());
      qw.orderByDesc("dfm_createTime");
      qw.last(" limit 1");
      mem = memService.getOne(qw);
      jsonObject.put("mem",mem);
      qw=new QueryWrapper();
      qw.eq("dfa_dfiId",funInfo.getDfmId());
      qw.orderByDesc("dfa_createTime");
      qw.last(" limit 1");
      aiApp = aiAppService.getOne(qw);
      jsonObject.put("aiApp",aiApp);
    }
    return Result.ok(jsonObject);
  }
}
