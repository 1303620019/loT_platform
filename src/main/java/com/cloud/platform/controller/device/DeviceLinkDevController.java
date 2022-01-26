package com.cloud.platform.controller.device;


import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.service.device.IDeviceLinkDevService;
import com.cloud.platform.service.device.IDeviceLinkLinksService;
import com.cloud.platform.service.device.IDeviceLinkOsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设备信息字段 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Slf4j
@Api(tags = "设备硬件信息")
@RestController
@RequestMapping("/dev")
public class DeviceLinkDevController {
  @Autowired
  private IDeviceLinkDevService devService;
  @Autowired
  private IDeviceLinkOsService osService;
  @Autowired
  private IDeviceLinkLinksService linkLinksService;

  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody DeviceLinkDevREQ req){
    return devService.search(req);
  }

  @ApiOperation("获取基础信息")
  @PostMapping("/base/info")
  public Result baseInfo(@RequestBody DeviceLinkDevREQ req){ return devService.baseInfo(req); }

  @ApiOperation("升级列表")
  @PostMapping("/upgrade/search")
  public ResultVo upgradeSearch(@RequestBody DeviceLinkDevREQ req){
    return osService.upgradeSearch(req);
  }
  @ApiOperation("设备接口列表")
  @PostMapping("/getLinks")
  public ResultVo getLinks(@RequestBody DeviceLinkDevREQ req){
    return linkLinksService.getList(req);
  }

}
