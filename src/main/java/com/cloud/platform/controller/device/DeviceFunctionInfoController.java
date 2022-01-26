package com.cloud.platform.controller.device;


import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.req.FunctionREQ;
import com.cloud.platform.service.device.function.IDeviceFunctionAiappService;
import com.cloud.platform.service.device.function.IDeviceFunctionInfoService;
import com.cloud.platform.service.device.function.IDeviceFunctionStateService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 设备运行状态 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Slf4j
@RestController
@RequestMapping("/function")
public class DeviceFunctionInfoController {
  @Resource
  private IDeviceFunctionInfoService infoService;
  @Resource
  private IDeviceFunctionStateService stateService;
  @Resource
  private IDeviceFunctionAiappService aiAppService;


  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody FunctionREQ req){
    return infoService.search(req);
  }

  @ApiOperation("设备运行状态信息")
  @PostMapping("/stateInfo")
  public Result stateInfo(@RequestBody DeviceLinkDevREQ req){
    return infoService.stateInfo(req);
  }
  @ApiOperation("其他接口运行状态信息")
  @PostMapping("/state/list")
  public ResultVo stateList(@RequestBody DeviceLinkDevREQ req){
    return stateService.getStateList(req);
  }
  @ApiOperation("其他接口运行状态信息")
  @PostMapping("/app")
  public ResultVo AppList(@RequestBody DeviceLinkDevREQ req){
    return aiAppService.getAppList(req);
  }
}
