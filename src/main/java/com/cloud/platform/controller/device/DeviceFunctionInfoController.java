package com.cloud.platform.controller.device;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.cfg.DeviceCfgLog;
import com.cloud.platform.mapper.device.function.DeviceFunctionInfoMapper;
import com.cloud.platform.req.DeviceLinkDevREQ;
import com.cloud.platform.req.FunctionREQ;
import com.cloud.platform.service.device.cfg.IDeviceCfgLogService;
import com.cloud.platform.service.device.function.IDeviceFunctionInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  @Autowired
  private IDeviceFunctionInfoService infoService;
  @Autowired
  private IDeviceCfgLogService cfgLogService;
  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody FunctionREQ req){
    return infoService.search(req);
  }

  @ApiOperation("配置列表")
  @PostMapping("/cfg/search")
  public ResultVo cfgSearch(@RequestBody FunctionREQ  req){
    log.info("设备配置接受的参数：{}",req.toString());
    if (StringUtils.isEmpty(req.getDeviceId())){
      return ResultVo.error("请求参数不能为空");
    }
    return infoService.cfgSearch(req);
  }


  @ApiOperation("配置管理保存")
  @PostMapping("/cfg/event")
  public Result cfgSaveLog(@RequestBody DeviceCfgLog cfgLog){
    if (cfgLog.getType() == 0){
      cfgLogService.save(cfgLog);
    }
    return Result.ok();
  }
}
