package com.cloud.platform.controller.device;


import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.cfg.DeviceCfgLog;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DeviceCfgLogREQ;
import com.cloud.platform.service.device.cfg.IDeviceCfgLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 配置信息 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@RestController
@RequestMapping("/cfg")
public class DeviceCfgLogController {

   @Resource
   private IDeviceCfgLogService  cfgLogService;

  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody DeviceCfgLogREQ req){
    return cfgLogService.search(req);
  }

  @ApiOperation("配置管理保存")
  @PostMapping("/event")
  public Result cfgSaveLog(@RequestBody DeviceCfgLog cfgLog){
    if (cfgLog.getType() == 0){
      cfgLogService.save(cfgLog);
    }
    return Result.ok();
  }
  @ApiOperation("配置管理保存")
  @ApiImplicitParam(name = "cfgLogId",value ="配置记录id",required=true,dataType="String",paramType = "query")
  @DeleteMapping("/del")
  public Result delCfgLog(@RequestBody DeviceCfgLogREQ req){
    return  cfgLogService.del(req.getDcId());
  }
}
