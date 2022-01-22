package com.cloud.platform.controller.device;


import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.DeviceArchives;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.service.device.IDeviceArchivesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.annotation.RequestScope;

/**
 * <p>
 * 设备档案 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Slf4j
@RestController
@RequestMapping("/archives")
public class DeviceArchivesController {

  @Autowired
  private IDeviceArchivesService archivesService;

  @ApiOperation("添加设备档案")
  @PutMapping
  public Result  save(@RequestBody DeviceArchives deviceArchives){
    return archivesService.saveArchives(deviceArchives);
  }
  @ApiOperation("获取设备档案信息")
  @ApiImplicitParam(name = "id",value ="档案id ",required=true,dataType="String",paramType = "query")
  @GetMapping("/{id}")
  public Result  getArchives(@PathVariable("id") String id){
    return archivesService.getArchives(id);
  }

  @ApiOperation("修改档案信息")
  @PostMapping
  public Result  editArchives(@RequestBody DeviceArchives deviceArchives){
    return archivesService.edit(deviceArchives);
  }

  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody DeviceArchivesREQ req){
   return archivesService.search(req);
  }
  @ApiOperation("获取列表Arc")
  @PostMapping("/searchArc")
  public ResultVo searchArc(@RequestBody DeviceArchivesREQ req){
    return archivesService.searchArc(req);
  }

  @ApiOperation("获取列表")
  @PostMapping("/device/search")
  public ResultVo devicesearch(@RequestBody DeviceArchivesREQ req){
    return archivesService.search(req);
  }
  @ApiOperation("设备升级获取列表")
  @PostMapping("/upgrade/search")
  public ResultVo upgradeSearch(@RequestBody DeviceArchivesREQ req){
    return archivesService.upgradeSearch(req);
  }
  @ApiOperation("删除档案信息")
  @ApiImplicitParam(name = "id",value ="档案id ",required=true,dataType="String",paramType = "query")
  @DeleteMapping("/{daId}")
  public Result  delArchives(@PathVariable("daId") String daId){
    return archivesService.del(daId);
  }

}
