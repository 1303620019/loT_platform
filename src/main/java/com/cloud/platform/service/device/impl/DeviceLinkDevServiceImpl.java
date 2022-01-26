package com.cloud.platform.service.device.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.*;
import com.cloud.platform.mapper.device.DeviceLinkDevMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.service.device.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备信息字段 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Service
public class DeviceLinkDevServiceImpl extends ServiceImpl<DeviceLinkDevMapper, DeviceLinkDev>
        implements IDeviceLinkDevService {
  @Autowired
  private IDeviceArchivesService archivesService;
  @Resource
  private IDeviceLinkInfoService linkInfoService;
  @Resource
  private IDeviceLinkOsService osService;
  @Resource
  private IDeviceLinkCpuService cpuService;
  @Resource
  private IDeviceLinkDiskService  diskService;
  @Resource
  private IDeviceLinkLinksService  linksService;
  @Resource
  private IDeviceLinkMemService  memService;

  @Resource
  private  IDeviceLinkAiService aiService;

  @Override
  public String saveCreatLinkDev(Map map) {
    if (!ObjectUtils.isEmpty(map.get("dev"))) {
      Map<String, Object> dev = JSON.parseObject(map.get("dev").toString(), Map.class);
      dev.put("deviceId",map.get("deviceId"));
      DeviceLinkDev linkDev = createLinkDev(dev);
      linkDev.setDldDliId(map.get("dliIdLog").toString());
      baseMapper.insert(linkDev);
      return linkDev.getDldId();
    }
    return null;
  }

  @Override
  public Boolean upateDevStatus(Map map) {
    DeviceLinkDev linkDev = baseMapper.selectOneByDeviceId(map.get("deviceId").toString());
    if (!ObjectUtils.isEmpty(linkDev)){
      linkDev.setDldDevStatusNum(1);
      linkDev.setDldBreakReason(ObjectUtils.isEmpty(map.get("reason"))?null:map.get("reason").toString());
      baseMapper.updateById(linkDev);
    }

    return true;
  }


  @Override
  public Result baseInfo(DeviceLinkDevREQ req) {
    QueryWrapper qw=new QueryWrapper();
    DeviceLinkDev dev=null;
    JSONObject jsonObject=null;
    String[] splitStr = req.getMids().split(",");
    String mid = splitStr[0]; //0下标代表基础信息
    req.setMids(mid);
    DeviceLinkInfo linkInfo = linkInfoService.getLinkInfo(req);
    if (!ObjectUtils.isEmpty(linkInfo)){
      qw.eq("dld_dli_id",linkInfo.getDilId());
      qw.eq("dld_device_id",req.getDeviceId());
      qw.orderByDesc("dld_createTime");
      qw.last(" limit 1");
      dev = baseMapper.selectOne(qw);
    }
    if (!ObjectUtils.isEmpty(dev)){
      jsonObject = createDeviceInfo(dev);
      jsonObject.put("dev",dev);
    }
    return Result.ok(jsonObject);
  }

  public JSONObject createDeviceInfo(DeviceLinkDev dev){
    JSONObject jsonObject=new JSONObject();
    QueryWrapper qw=new QueryWrapper();
    DeviceLinkOs os=null;
    DeviceLinkCpu cpu=null;
    DeviceLinkDisk disk=null;
    DeviceLinkMem men=null;
    DeviceLinkAi  ai=null;
    List<DeviceLinkLinks> list=new ArrayList<>();
    //查询设备基本信息
    qw=new QueryWrapper();
    qw.eq("dlo_dle_id",dev.getDldId());
    qw.orderByDesc("dlo_createTime");
    qw.last(" limit 1");
    os = osService.getOne(qw);
    //查询cpu
    qw=new QueryWrapper();
    qw.eq("dld_dli_id",dev.getDldId());
    qw.orderByDesc("dlc_createTime");
    qw.last(" limit 1");
    cpu = cpuService.getOne(qw);
    //查询磁盘内存
    qw=new QueryWrapper();
    qw.eq("dld_dli_id",dev.getDldId());
    qw.orderByDesc("dld_createTime");
    qw.last(" limit 1");
    disk= diskService.getOne(qw);
    //AI模块信息
    qw=new QueryWrapper();
    qw.eq("dla_dldId",dev.getDldId());
    qw.orderByDesc("dla_createTime");
    qw.last(" limit 1");
    ai= aiService.getOne(qw);

    //查询物理内存
    qw=new QueryWrapper();
    qw.eq("dlm_dli_id",dev.getDldId());
    qw.orderByDesc("dlm_createTime");
    qw.last(" limit 1");
    men = memService.getOne(qw);
    //查询接口集合
    qw=new QueryWrapper();
    qw.eq("dll_dli_id",dev.getDldId());
    qw.orderByDesc("dll_createTime");
    list = linksService.list(qw);

    jsonObject.put("os",os);
    jsonObject.put("cpu",cpu);
    jsonObject.put("disk",disk);
    jsonObject.put("men",men);
    jsonObject.put("ai",ai);
    jsonObject.put("list",list);
    return  jsonObject;
  }
  @Override
  public ResultVo search(DeviceLinkDevREQ req) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 条件分页查询
    QueryWrapper wrapper=new QueryWrapper();
    //认证结果
    if(!ObjectUtils.isEmpty(req.getDeviceId())){
      wrapper.eq("dld_device_id",req.getDeviceId());
    }
    //连接类型
    if (!ObjectUtils.isEmpty(req.getDevStatusNum())){
      wrapper.eq("dld_devStatus_num",req.getDevStatusNum());
    }
    //发生时间起
    if (!StringUtils.isEmpty(req.getStartTime())){
      // String format = sdf.format(req.getStartTime());
      wrapper.ge("dld_createTime",req.getStartTime());
    }
    //终止时间
    if (!StringUtils.isEmpty(req.getEndTime())){
     // String format = sdf.format(req.getEndTime());
      wrapper.le("dld_createTime",req.getEndTime());
    }
   //连接结果
    if (!ObjectUtils.isEmpty(req.getDevStatusNum())){
      wrapper.le("dld_devStatus",req.getDevStatusNum());
    }
    IPage<DeviceLinkDev>  devREQIPage = baseMapper.selectPage(req.getPage(), wrapper);
    return ResultVo.ok(devREQIPage.getRecords(),devREQIPage.getTotal());
  }


  public DeviceLinkDev createLinkDev(Map map){
    DeviceArchives archives = archivesService.getArchivesByDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString(),ObjectUtils.isEmpty(map.get("mfgInfo"))?null:map.get("mfgInfo").toString());
    DeviceLinkDev linkDev=new DeviceLinkDev();
    linkDev.setDldDevname(ObjectUtils.isEmpty(map.get("devName"))?null:map.get("devName").toString());
    linkDev.setDldDevtype(ObjectUtils.isEmpty(map.get("devType"))?null:map.get("devType").toString());
    linkDev.setDldMfginfo(ObjectUtils.isEmpty(map.get("mfgInfo"))?null:map.get("mfgInfo").toString());
    linkDev.setDldDevstatus(ObjectUtils.isEmpty(map.get("devStatus"))?null:map.get("devStatus").toString());
    linkDev.setDldHardversion(ObjectUtils.isEmpty(map.get("hardVersion"))?null:map.get("hardVersion").toString());
    linkDev.setDldDeviceId(ObjectUtils.isEmpty(map.get("deviceId"))?null:map.get("deviceId").toString());
    if (!ObjectUtils.isEmpty(archives))linkDev.setDldauth(0);
    else linkDev.setDldauth(1);
    linkDev.setDldDevStatusNum(0);
    linkDev.setDldCreatetime(new Date());
    return linkDev;
  }

}
