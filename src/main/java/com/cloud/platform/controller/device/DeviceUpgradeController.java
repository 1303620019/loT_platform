package com.cloud.platform.controller.device;


import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;

import com.cloud.platform.req.DeviceUpgradeREQ;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设备升级 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Slf4j
@RestController
@RequestMapping("/upgrade")
public class DeviceUpgradeController {

  @Autowired
  private IDeviceUpgradeService upgradeService;
   @ApiOperation("获取工作任务id")
   @GetMapping("/getJobId")
   public Result getJobId(){return upgradeService.getJObid(); }

  @ApiOperation("升级设备")
  @PostMapping("/exce")
  public Result exceUpgrade(@RequestBody DeviceUpgradeREQ req){
     log.info("参数是{}",req);
     return upgradeService.exceUpgrade(req);
   }

  @ApiOperation("升级列表")
  @PostMapping("/taxkList")
  public ResultVo taxkList(@RequestBody DeviceUpgradeREQ req){
     return upgradeService.taskList(req);
  }

  @ApiOperation("状态查询")
  @PostMapping("/status/query")
  public Result statusQuery(@Param("jobId") Integer jobId,@Param("deviceId") String deviceId){
    return upgradeService.statusQuery(jobId,deviceId);
  }
}
