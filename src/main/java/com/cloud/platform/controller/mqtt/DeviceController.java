package com.cloud.platform.controller.mqtt;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cloud.platform.base.Result;
import com.cloud.platform.entity.device.upgrade.DeviceUpgradeResult;
import com.cloud.platform.service.*;
import com.cloud.platform.service.device.*;
import com.cloud.platform.service.device.function.*;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeResultService;
import com.cloud.platform.service.device.upgrade.IDeviceUpgradeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author byl
 * @version 1.0
 * @description: 设备管理模块
 * @date 2021-12-28 11:38
 */
@Slf4j
@Api(tags = "设备管理")
@RestController
@RequestMapping("/client")
public class DeviceController {
  @Autowired
  private IDeviceMessageLogService messageLogService;
  @Autowired
  private IDeviceLinkCpuService cpuService;
  @Autowired
  private IDeviceLinkInfoService linkInfoService;
  @Autowired
  private IDeviceLinkLinksService linkLinksService;
  @Autowired
  private IDeviceLinkDiskService diskService;
  @Autowired
  private IDeviceLinkDevService devService;
  @Autowired
  private IDeviceLinkOsService osService;
  @Autowired
  private IDeviceLinkMemService memService;
  @Autowired
  private IMqttHttpPort mqttHttpPort;
  @Autowired
  private IDeviceUpgradeService upgradeService;
  @Autowired
  private IDeviceFunctionInfoService functionInfoService;
  @Autowired
  private IDeviceFunctionMemService functionMemService;
  @Autowired
  private IDeviceFunctionStateService functionStateService;
  @Autowired
  private IDeviceFunctionRepperiodService repperiodService;
  @Autowired
  private IDeviceFunctionTemperatureService temperatureService;

  @Autowired
  private IDeviceAlarmLogService alarmLogService;

  @Autowired IDeviceRestartLogService logService;

  @Autowired
  private IDeviceLinkAiService linkAiService;
  @Autowired
  private IDeviceLinkFileService  linkFileService;
  @Autowired
  private IDeviceLinkFileSignService  signService;
  @Autowired
  private IDeviceUpgradeResultService upgradeResultService;
  @Resource
  private IDeviceFunctionAiappService aiappService;
  /**
   * 功能描述: <br>
   * 官方文档〈https://docs.emqx.cn/broker/v4.3/rule/rule-engine.html#%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E%E5%85%B8%E5%9E%8B%E5%BA%94%E7%94%A8%E5%9C%BA%E6%99%AF%E4%B8%BE%E4%BE%8B〉
   *
   * @Param: [map]
   * @Return: void
   * @Author: byl
   * @Date:
   */
  @PostMapping("/event")
  @SuppressWarnings("unchecked")
  public void event(@RequestBody Map<String, Object> map) throws Exception {
    Result result = messageLogService.saveMessage(map);
    if (MapUtils.isNotEmpty(map) && !ObjectUtils.isEmpty(map.get("payload"))) {
      Object payload1 = map.get("payload");
      String DtoStr = JSON.toJSONString(payload1);
      Map<String, Object> stringObjectMap = JSON.parseObject(payload1.toString(), Map.class);
      Map<String, Object> param = null;
      String linkInfoId = null;
      if (!ObjectUtils.isEmpty(stringObjectMap.get("param"))) {
        param = JSON.parseObject(stringObjectMap.get("param").toString(), Map.class);
        param.put("deviceId", stringObjectMap.get("deviceId"));
      }
      // 设备接入动作
      if (stringObjectMap.get("type").equals("EVENT_LINKUP") && MapUtils.isNotEmpty(param)) {
        linkInfoId = linkInfoService.saveLinkInfo(stringObjectMap);
        param.put("dliIdLog", linkInfoId);
        Boolean linkUp = link_up(param);
        if (linkUp) {
          mqttHttpPort.sendMsg(result.getData(), null,"response");
        }
        //断开设备连接
      } else if (stringObjectMap.get("type").equals("EVENT_LINKDOWN") && MapUtils.isNotEmpty(param)) {
        Boolean linkDown = devService.upateDevStatus(param);
        if (linkDown) {
          mqttHttpPort.sendMsg(result.getData(), null,"response");
        }
        //心跳应答
      } else if (stringObjectMap.get("type").equals("EVENT_HEARTBEAT")) {
        mqttHttpPort.sendMsg(result.getData(),null,"response" );
        //平台向终端下发升级
      } else if (stringObjectMap.get("type").equals("CMD_STATUS_QUERY")) {
        param = JSON.parseObject(stringObjectMap.get("param").toString(), Map.class);
        String deviceId = param.get("deviceId").toString();
        upgradeService.updateUpgrade(deviceId,param);
     //设备升级命令应答
     }else if(stringObjectMap.get("type").equals("CMD_SYS_UPGRADE")){
        log.info("CMD_DATETIME_SYN-参数列表：{}",stringObjectMap.toString());
      //设备升级结果上报 不回应
    } else if (stringObjectMap.get("type").equals("REP_JOB_RESULT")) {
     upgradeResultService.saveUpgradeResult(param);
      //设备状态查询命令进行应答 不回应
    }else if (stringObjectMap.get("type").equals("REP_SYS_STATUS")){
        String menId = functionMemService.saveFunctionMen(param);
        if (!StringUtils.isBlank(menId)){
          param.put("memUsed",menId);
        }
        String infoId = functionInfoService.saveFunctionInfo(param);
        if (!StringUtils.isBlank(infoId)){
          param.put("infoId",infoId);
          functionStateService.saveFunctionState(param);
        }
        if (!StringUtils.isBlank(infoId)){
          param.put("infoId",infoId);
          aiappService.saveFunctionAiapp(param);
        }
      //终端上报软硬件信息至平台 不回应
      }else if (stringObjectMap.get("type").equals("CMD_INFO_QUERY")&& MapUtils.isNotEmpty(param)) {
         linkInfoId = linkInfoService.saveLinkInfo(stringObjectMap);
         param.put("dliIdLog", linkInfoId);
         link_up(param);
      //终端上报软硬件信息至平台 不回应
      } else if (stringObjectMap.get("type").equals("CMD_SYS_SET_CONFIG")) {
        log.info("CMD_SYS_SET_CONFIG-参数列表：{}",stringObjectMap.toString());
      //设备时间同步应答 不保存
      }else if (stringObjectMap.get("type").equals("CMD_DATETIME_SYN")) {
        log.info("CMD_DATETIME_SYN-参数列表：{}",stringObjectMap.toString());
        //备告警或其他事件上报至平台
      }else if (stringObjectMap.get("type").equals("EVENT_SYS_ALARM")) {
        log.info("EVENT_SYS_ALARM-参数列表：{}",stringObjectMap.toString());
        Boolean aBoolean = alarmLogService.saveAlarmLog(param);
        //设备日志召回应答
      }else if (stringObjectMap.get("type").equals("CMD_SYS_LOG")) {
        log.info("CMD_SYS_LOG-参数列表：{}",param.toString());
        String signId = signService.saveFileSign(param);
        if (!StringUtils.isBlank(signId)){
          param.put("signId",signId);
        }
        Boolean aBoolean = linkFileService.saveFile(param);
        //设备控制命令应答 不保存
      }else if (stringObjectMap.get("type").equals("CMD_CTRL")) {
        log.info("CMD_CTRL-参数列表：{}",stringObjectMap.toString());
        logService.editLog(stringObjectMap.get("deviceId").toString(),"200");
      }

    }
  }

  //设备上报事件
  public Boolean link_up(Map<String, Object> param) throws Exception {
    String devId = devService.saveCreatLinkDev(param);
    param.put("dliId", devId);
    Boolean saveAi = linkAiService.saveAi(param);
    Boolean cpu = cpuService.saveLinkCpu(param);
    Boolean links = linkLinksService.saveLinkLinks(param);
    Boolean disk = diskService.saveLinkDisk(param);
    Boolean os = osService.saveCreatLinkOs(param);
    Boolean mem = memService.savelinkMem(param);
    Boolean repperiod = repperiodService.saveRepperiod(param);
    Boolean temperature = temperatureService.saveTemperature(param);
    if (cpu && links && saveAi && disk && StringUtils.isNotEmpty(devId) && os && mem) {
      return true;
    }
    if (cpu && links && saveAi && disk && StringUtils.isNotEmpty(devId) && os && mem && repperiod && temperature ) {
      return true;
    }
    return false;
  }



}
