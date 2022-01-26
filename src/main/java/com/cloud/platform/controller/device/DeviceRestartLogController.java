package com.cloud.platform.controller.device;


import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.req.DeviceRestartLogREQ;
import com.cloud.platform.service.device.IDeviceRestartLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 重启日志 控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@RestController
@RequestMapping("/restart/log")
public class DeviceRestartLogController {
  @Autowired
  private IDeviceRestartLogService logService;

  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody DeviceRestartLogREQ req){

    return  logService.search(req);
  }

}
