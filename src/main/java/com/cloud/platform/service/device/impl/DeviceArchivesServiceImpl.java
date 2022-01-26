package com.cloud.platform.service.device.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.entity.device.DeviceArchives;
import com.cloud.platform.mapper.device.DeviceArchivesMapper;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.service.device.IDeviceArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 设备档案 服务实现类
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Service
public class DeviceArchivesServiceImpl
        extends ServiceImpl<DeviceArchivesMapper, DeviceArchives> implements IDeviceArchivesService {
  @Autowired
  private DeviceArchivesMapper archivesMapper;
  @Override
  public Result saveArchives(DeviceArchives archives) {
    baseMapper.insert(archives);
    return Result.ok();
  }

  @Override
  public Result getArchives(String id) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("da_id",id);
    wrapper.orderByDesc("da_createTime");
    DeviceArchives deviceArchives = baseMapper.selectOne(wrapper);
    return Result.ok(deviceArchives);
  }
  @Override
  public DeviceArchives getArchivesByDeviceId(String deviceId,String mfgInfo) {
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("da_deviceId",deviceId);
    wrapper.eq("da_device_mfgInfo",mfgInfo);
    wrapper.orderByDesc("da_createTime");
    DeviceArchives deviceArchives = baseMapper.selectOne(wrapper);
    return deviceArchives;
  }
  @Override
  public Result del(String id) {
    DeviceArchives deviceArchives = baseMapper.selectById(id);
    deviceArchives.setEditTime(new Date());
    deviceArchives.setState("1");
    baseMapper.updateById(deviceArchives);
    return Result.ok();
  }

  @Override
  public ResultVo search(DeviceArchivesREQ req) {
    IPage<DeviceArchives> page=new Page<DeviceArchives>();
    IPage<DeviceArchives> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceArchives> devREQIPage = archivesMapper.search(page,req);
    return ResultVo.ok(devREQIPage.getRecords(),devREQIPage.getTotal());
  }
  @Override
  public ResultVo searchArc(DeviceArchivesREQ req) {
    IPage<DeviceArchives> page=new Page<DeviceArchives>();
    IPage<DeviceArchives> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceArchives> devREQIPage = archivesMapper.searchArc(page,req);
    return ResultVo.ok(devREQIPage.getRecords(),devREQIPage.getTotal());
  }


  @Override
  public ResultVo upgradeSearch(DeviceArchivesREQ req) {
    IPage<DeviceArchives> page=new Page<DeviceArchives>();
    IPage<DeviceArchives> page1 = req.getPage();
    page.setPages(page1.getPages());
    page.setSize(page1.getSize());
    page.setTotal(page1.getTotal());
    IPage<DeviceArchives> devREQIPage = archivesMapper.upgradeSearch(page,req);
    return ResultVo.ok(devREQIPage.getRecords(),devREQIPage.getTotal());
  }

  @Override
  public Result edit(DeviceArchives archives) {
    archives.setEditTime(new Date());
    baseMapper.updateById(archives);
    return Result.ok();
  }
}
