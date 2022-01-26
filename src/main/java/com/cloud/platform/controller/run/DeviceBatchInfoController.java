package com.cloud.platform.controller.run;


import com.cloud.platform.comm.Result;
import com.cloud.platform.comm.ResultVo;
import com.cloud.platform.req.DeviceBatchInfoREQ;
import com.cloud.platform.service.device.run.IDeviceBatchInfoService;
import com.cloud.platform.service.device.run.IDeviceBatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 设备批次信息 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Slf4j
@Api("设备批次管理")
@RestController
@RequestMapping("/batch")
public class DeviceBatchInfoController {

  @Resource
  private IDeviceBatchInfoService infoService;
  @Resource
  private IDeviceBatchService batchService;
  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody DeviceBatchInfoREQ req){ return infoService.search(req); }
  @ApiOperation("获取召回项列表")
  @GetMapping("/recall")
  public Result recallList(){
    return infoService.recallList();
  }
  @ApiOperation("保存批次数据")
  @PutMapping
  public Result saveBatch(@RequestBody DeviceBatchInfoREQ req){ return infoService.saveBatch(req); }
  @ApiOperation("根据批次查找设备记录")
  @PostMapping("/batchId")
  public ResultVo getBatchInfoByBatchId(@RequestBody DeviceBatchInfoREQ req){
    return batchService.getBatchInfoByBatchId(req);
  }
}
