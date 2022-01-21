package com.cloud.platform.controller.task;


import com.cloud.platform.base.Result;
import com.cloud.platform.base.ResultVo;
import com.cloud.platform.entity.device.task.DeviceUpgradeTask;
import com.cloud.platform.req.DeviceUpgradeTaskREQ;
import com.cloud.platform.service.device.task.IDeviceUpgradeTaskService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 计划任务表 前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Slf4j
@RestController
@RequestMapping("/upgrade/task")
public class DeviceUpgradeTaskController {
  @Resource
  private IDeviceUpgradeTaskService taskService;

  @ApiOperation("任务列表")
  @PostMapping("/search")
  private ResultVo search(@RequestBody DeviceUpgradeTaskREQ req){
    return taskService.searche(req);
  }

  @ApiOperation("获取计划id")
  @GetMapping("/getId")
  private Result getId(){
    return taskService.getId();
  }

  @ApiOperation("保存计划")
  @PostMapping("/save")
  private Result saveUpgradeTask(@RequestBody DeviceUpgradeTaskREQ req){
    return taskService.saveTask(req);
  }
  @ApiOperation("保存计划")
  @PostMapping("/edit")
  private Result editUpgradeTask(@RequestBody DeviceUpgradeTaskREQ req){
    return taskService.editUpgradeTask(req);
  }
  @ApiOperation("修改执行状态")
  @GetMapping("/state/{taskId}")
  private  Result editExceState(@PathVariable("taskId") String taskId){
    return  taskService.editExceState(taskId);
  }
  @ApiOperation("获取计划")
  @GetMapping("/{taskId}")
  private  Result getUpgradeTask(@PathVariable("taskId") String taskId){
    return  taskService.getUpgradeTask(taskId);
  }
  @ApiOperation("删除计划")
  @DeleteMapping
  private Result delTask(@Param("id") String id){
    return taskService.del(id);
  }
}
