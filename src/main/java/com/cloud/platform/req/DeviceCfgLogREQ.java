package com.cloud.platform.req;


import com.baomidou.mybatisplus.annotation.TableField;
import com.cloud.platform.comm.BaseRequest;
import com.cloud.platform.entity.device.cfg.DeviceCfgLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.req
 * @author:byl
 * @createTime:2022/1/14 16:01
 * @version:1.0
 */
@ApiModel(value = "DeviceCfgLogREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceCfgLogREQ extends BaseRequest<DeviceCfgLog> {

  @ApiModelProperty(value="记录id")
  private String dcId;

  @ApiModelProperty(value="设备编号")
  private String deviceId;

  @ApiModelProperty(value = "设备名称  ")
  @TableField("dc_devName")
  private String devName;

  @ApiModelProperty(value = "系统cpu使用率上限阀值")
  private Integer cpu;

  @ApiModelProperty(value = "系统内存使用率上限阀值")
  private Integer memLmt;

  @ApiModelProperty(value = "系统储存占用率上限阀值")
  private Integer diskLmt;

  @ApiModelProperty(value = "主板温度监控低温阀值")
  private Integer temLow;

  @ApiModelProperty(value = "主板温度监控高温阀值")
  private Integer temHigh;

  @ApiModelProperty(value = "0-保存  1-下发  2-召回")
  private Integer type;

  @ApiModelProperty(value = "同步设备当前时间")
  private Date synDateTime;

  @ApiModelProperty(value = "创建时间")
  private Date createTime;
}
