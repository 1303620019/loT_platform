package com.cloud.platform.req;

import com.cloud.platform.comm.BaseRequest;
import com.cloud.platform.entity.device.DeviceLinkDev;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.req
 * @author:byl
 * @createTime:2022/1/14 16:01
 * @version:1.0
 */
@ApiModel(value = "DeviceLinkDevREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceLinkDevREQ extends BaseRequest<DeviceLinkDev> {


  @ApiModelProperty(value="设备编号")
  public String deviceId;

  @ApiModelProperty(value="请求集合mid")
  public String  mids;

  @ApiModelProperty(value="请求类型集合")
  public String types;

  @ApiModelProperty(value="连接类型")
  public Integer devStatusNum;

  @ApiModelProperty(value="认证结果")
  public Integer authNum;

  @ApiModelProperty(value="发生时间起")
  public String startTime;

  @ApiModelProperty(value="终止时间")
  public String endTime;


  @ApiModelProperty(value="连接结果")
  public Integer LinkStatusNum;

  @ApiModelProperty(value="终端类型")
  public String dldDevtype;


  @ApiModelProperty(value="设备厂商")
  public String dldMfginfo;

  @ApiModelProperty(value="系统名称")
  public String dloDistro;

  @ApiModelProperty(value="t_device_link_dev表id")
  public String devId;

  @ApiModelProperty(value="t_device_function_info表id")
  public String dfiId;

  @ApiModelProperty(value="升级类型")
  public Integer upgradeType;
}
