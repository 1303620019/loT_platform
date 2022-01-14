package com.cloud.platform.controller.mqtt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.platform.base.BaseRequest;
import com.cloud.platform.base.Result;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.cloud.platform.entity.device.DeviceLinkFileSign;
import com.cloud.platform.entity.device.DeviceMessageLog;
import com.cloud.platform.entity.device.DeviceUpgrade;
import com.cloud.platform.entity.device.function.DeviceFunctionRepperiod;
import com.cloud.platform.entity.device.function.DeviceFunctionTemperature;
import com.cloud.platform.req.DeviceConfigureREQ;
import com.cloud.platform.req.MessageHeadREQ;
import com.cloud.platform.req.PageREQ;
import com.cloud.platform.service.IMqttHttpPort;
import com.cloud.platform.service.device.IDeviceLinkFileService;
import com.cloud.platform.service.device.IDeviceLinkFileSignService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * @description: 详情访问https://docs.emqx.cn/broker/v4.1/advanced/http-api.html#%E6%8E%A5%E5%8F%A3%E5%AE%89%E5%85%A8
 * @projectName:loT_platform
 * @see:com.cloud.platform.controller
 * @author:byl
 * @createTime:2022/1/7 18:51
 * @version:1.0
 */
@Slf4j
@Api(tags = "mqtt接口调用")
@RestController
@RequestMapping("/mqtt")
public class MqttController {

  @Resource
  private IMqttHttpPort iMqttHttpPort;
  @Autowired
  private IDeviceLinkFileSignService  fileSignService;
  @Autowired
  private IDeviceLinkFileService fileService;

  @ApiOperation("mqtt基本信息及运行状态")
  @GetMapping("/nodes")
  public Result findBrokers() throws IOException {
    JSONObject data = null;
    Result brokers = iMqttHttpPort.findBrokers();
    if (ObjectUtils.isEmpty(brokers.getData())) {
      return Result.ok("未查询到信息，ip地址不对");
    }
    JSONObject json = JSONObject.parseObject(brokers.getData().toString());
    if (!ObjectUtils.isEmpty(json)) {
      data = JSONObject.parseObject(json.get("data").toString());
      String node_status = data.get("node_status").toString();// mqtt运行状态 Running 运行状态
    }
    return Result.ok(data);
  }

  @ApiOperation("所有客户端的信息")
  @PostMapping("/clients")
  public Result findClients(@RequestBody PageREQ req) throws IOException {
    JSONArray data = null;
    Result brokers = iMqttHttpPort.findClients(req.getPageStr(), req.getLimitStr());
    if (StringUtils.isEmpty(brokers)) {
      return Result.ok("未查询到信息，ip地址不对");
    }
    if (!ObjectUtils.isEmpty(brokers.getData())) {
      JSONObject object = JSONObject.parseObject(brokers.getData().toString());
      data = JSONObject.parseArray(object.get("data").toString());
      for (int i = 0; i < data.size(); i++) {
        String node_status = data.getJSONObject(i).get("connected").toString();// mqtt运行状态 Running 运行状态
        String clientid = data.getJSONObject(i).get("clientid").toString();// mqtt运行状态 Running 客户端id
        log.info("客户端：" + clientid + "-运行状态：" + node_status);
      }
    }
    return Result.ok(data);
  }

  @ApiOperation("设备升级接口")
  @PostMapping("/upgrade")
  public void deviceUpgrade(@RequestBody  DeviceUpgrade upgrade){
    MessageHeadREQ messageLog=new MessageHeadREQ();
    messageLog.setMid(17);
    messageLog.setDeviceId("T20SHEIRI001202009140001");
    messageLog.setTimestamp(new Date().toString());
    messageLog.setType("CMD_SYS_UPGRADE");
    upgrade.setJobId(1);
    upgrade.setPolicy(1000);
    upgrade.setVersion("Version 1.0");
    upgrade.setUpgradeType(0);
    DeviceLinkFile file = fileService.getFile(upgrade.getDuFileId());
    DeviceLinkFileSign fileSign = fileSignService.getFileSign(file.getFsId());
    if (!ObjectUtils.isEmpty(fileSign)){
      file.setSign(fileSign);
    }
    if (!ObjectUtils.isEmpty(file)){
      upgrade.setFile(file);
    }
    messageLog.setParam(upgrade);
    messageLog.setMsg(null);
    log.info("元素排序：{}",JSONObject.toJSONString(messageLog));
   Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/T20SHEIRI001202009140001/device/command");
  }
  @ApiOperation("设备升级状态查询")
  @GetMapping("/status/{jobId}")
  public void queryStatus(@PathVariable("jobId")String jobId){
    JSONObject jsonObject=new JSONObject();
    MessageHeadREQ messageLog=new MessageHeadREQ();
    messageLog.setMid(17);
    messageLog.setDeviceId("T20SHEIRI001202009140001");
    messageLog.setTimestamp(new Date().toString());
    messageLog.setType("CMD_STATUS_QUERY");
    jsonObject.put("jobId",jobId);
    messageLog.setParam(jsonObject);
    Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/T20SHEIRI001202009140001/device/command");
  }
  @ApiOperation("设备配置修改命令")
  @PostMapping("/configure/update")
  public String   deviceConfigureUpdate(@RequestBody DeviceConfigureREQ req){
  log.info("参数是{}",req.toString());
    MessageHeadREQ messageLog=new MessageHeadREQ();
    messageLog.setMid(17);
    messageLog.setDeviceId("T20SHEIRI001202009140001");
    messageLog.setTimestamp(new Date().toString());
    messageLog.setType("CMD_SYS_SET_CONFIG");
    messageLog.setParam(req);
    messageLog.setMsg(null);
    log.info("元素排序：{}",JSONObject.toJSONString(messageLog));
    Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/T20SHEIRI001202009140001/device/command");
    return aBoolean.toString();
  }
  @ApiOperation("时间同步命令")
  @ApiImplicitParam(name = "dateTime",value ="同步的时间",required=true,dataType="String" )
  @PostMapping("/time/syn")
  public String  deviceTimeSyn(@RequestBody  String dateTime){
    log.info("参数是{}",dateTime);
    JSONObject object=new JSONObject();
    object.put("dateTime",dateTime);
    object.put("timeZone", TimeZone.getTimeZone("GMT+8"));
    MessageHeadREQ messageLog=new MessageHeadREQ();
    messageLog.setMid(17);
    messageLog.setDeviceId("T20SHEIRI001202009140001");
    messageLog.setTimestamp(new Date().toString());
    messageLog.setType("CMD_DATETIME_SYN");
    messageLog.setParam(object);
    messageLog.setMsg(null);
    log.info("元素排序：{}",JSONObject.toJSONString(messageLog));
    Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/T20SHEIRI001202009140001/device/command");
    return aBoolean.toString();
  }


  @ApiOperation("日志召回")
  @ApiImplicitParam(name = "logType",value ="0-全部 1-系统 2-操作 3-安全 4-驱动 5-broker 6-审计 7-调试  8-255",required=true,dataType="String",paramType = "query")
  @PostMapping("/log/recall")
  public String   deviceLogRecall(@RequestBody String logType){
    log.info("参数是{}",logType);
    JSONObject object=new JSONObject();
    //object.put("url","http://8.142.34.45:8991/file/uploadFile");
    object.put("url","http://192.168.1.146:8991/file/uploadFile");
    object.put("logType",logType);
    MessageHeadREQ messageLog=new MessageHeadREQ();
    messageLog.setMid(17);
    messageLog.setDeviceId("T20SHEIRI001202009140001");
    messageLog.setTimestamp(new Date().toString());
    messageLog.setType("CMD_SYS_LOG");
    messageLog.setParam(object);
    messageLog.setMsg(null);
    log.info("元素排序：{}",JSONObject.toJSONString(messageLog));
    Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/T20SHEIRI001202009140001/device/command");
    return aBoolean.toString();
  }

  @ApiOperation("设备控制")
  @ApiImplicitParam(name = "action",value ="os-reboot：重启终端系统,edge-reboot：重启终端组件 ",required=true,dataType="String",paramType = "query")
  @PostMapping("/regulate")
  public String   deviceRegulate(@RequestBody String action){
    log.info("参数是{}",action);
    JSONObject object=new JSONObject();
    object.put("action",action);
    MessageHeadREQ messageLog=new MessageHeadREQ();
    messageLog.setMid(17);
    messageLog.setDeviceId("T20SHEIRI001202009140001");
    messageLog.setTimestamp(new Date().toString());
    messageLog.setType("CMD_SYS_LOG");
    messageLog.setParam(object);
    messageLog.setMsg(null);
    log.info("元素排序：{}",JSONObject.toJSONString(messageLog));
    Boolean aBoolean = iMqttHttpPort.sendMsg(messageLog, "/v1/T20SHEIRI001202009140001/device/command");
    return aBoolean.toString();
  }

}
