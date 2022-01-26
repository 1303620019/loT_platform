package com.cloud.platform.controller.task;


import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;

import com.cloud.platform.req.DeviceUpgradeREQ;
import com.cloud.platform.req.DeviceUpgradeScheduleREQ;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeScheduleService;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
  @Resource
  private IDeviceUpgradeScheduleService scheduleService;

   @ApiOperation("获取工作任务id")
   @GetMapping("/getJobId")
   public Result getJobId(){return upgradeService.getJObid(); }

  @ApiOperation("升级设备")
  @PostMapping("/exce")
  public Result exceUpgrade(@RequestBody DeviceUpgradeREQ req){
     return upgradeService.exceUpgrade(req);
   }
  @ApiOperation("重新生成")
  @PostMapping("/againExce")
  public Result againExce(@Param("duId") String duId)
  {
    return upgradeService.againExce(duId);
  }
  @ApiOperation("升级记录列表")
  @PostMapping("/log")
  public ResultVo upgradeLog(@RequestBody DeviceUpgradeREQ req){
     return upgradeService.upgradeLog(req);
  }

  @ApiOperation("状态查询")
  @PostMapping("/status/query")
  public Result statusQuery(@Param("jobId") Integer jobId,@Param("deviceId") String deviceId){
    return upgradeService.statusQuery(jobId,deviceId);
  }

  @ApiOperation("查询进度")
  @PostMapping("/progress")
  public ResultVo progress(@RequestBody DeviceUpgradeScheduleREQ req){
    return scheduleService.search(req);
  }

}
