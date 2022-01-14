package com.cloud.platform.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.platform.entity.device.function.DeviceFunctionRepperiod;
import com.cloud.platform.entity.device.function.DeviceFunctionTemperature;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.req
 * @author:byl
 * @createTime:2022/1/13 15:28
 * @version:1.0
 */
@Data
@ApiModel(value = "DeviceConfigureREQ对象", description = "修改配置Req")
@Accessors(chain = true)
public class DeviceConfigureREQ {
  @JSONField(ordinal = 1)
  @ApiModelProperty(value = "设备名称")
  @JsonProperty("devName")
  public String devName;

  @JSONField(ordinal = 2)
  @ApiModelProperty(value = "CPU 监控阈值")
  @JsonProperty("cpuLmt")
  public String cpuLmt;


  @JSONField(ordinal = 3)
  @ApiModelProperty(value = "内存监控阈值")
  @JsonProperty("memLmt")
  public String memLmt;


  @JSONField(ordinal = 4)
  @ApiModelProperty(value = "磁盘监控阈值")
  @JsonProperty("diskLmt")
  public String diskLmt;


  @JSONField(ordinal = 5)
  @ApiModelProperty(value = "温度监控信息")
  @JsonProperty("temperature")
  public DeviceFunctionTemperature  temperature;


  @JSONField(ordinal = 6)
  @ApiModelProperty(value = "上报时间间隔")
  @JsonProperty("repPeriod")
  public DeviceFunctionRepperiod repPeriod;

}
