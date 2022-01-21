package com.cloud.platform.controller.market;


import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.market.DevicePatch;
import com.cloud.platform.req.DeviceArchivesREQ;
import com.cloud.platform.req.DevicePatchREQ;
import com.cloud.platform.service.device.market.IDevicePatchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 系统补丁信息表 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@RestController
@RequestMapping("/patch")
public class DevicePatchController {
  @Resource
  private IDevicePatchService patchService;

  @ApiOperation("获取列表")
  @PostMapping("/search")
  public ResultVo search(@RequestBody DevicePatchREQ req){
    return patchService.search(req);
  }

  @ApiOperation("删除记录")
  @DeleteMapping
  public Result del(@RequestBody DevicePatchREQ req){
    return patchService.delPath(req);
  }
  @ApiOperation("修改记录")
  @PostMapping("/edit")
  public Result edit(@RequestBody DevicePatch patch){
    return patchService.editPath(patch);
  }

  @ApiOperation("状态修改")
  @PostMapping("/edit/state")
  public Result editState(@RequestBody DevicePatchREQ req){
    return patchService.editState(req);
  }

  @ApiOperation("新增记录")
  @PutMapping
  public Result addPatch(@RequestBody DevicePatch patch){
    return patchService.savePath(patch);
  }

  @ApiOperation("新增记录")
  @GetMapping("/{paId}")
  public Result getPatch(@PathVariable("paId") String paId){
    DevicePatch Patch = patchService.getById(paId);
    return Result.ok(Patch);
  }
}
