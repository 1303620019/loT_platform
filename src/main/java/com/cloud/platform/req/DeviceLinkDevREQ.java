package com.cloud.platform.req;

import com.cloud.platform.base.BaseRequest;
import com.cloud.platform.entity.device.DeviceLinkDev;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
  private String deviceId;

  @ApiModelProperty(value="连接类型")
  private Integer devStatusNum;

  @ApiModelProperty(value="认证结果")
  private Integer authNum;

  @ApiModelProperty(value="发生时间起")
  private String startTime;

  @ApiModelProperty(value="终止时间")
  private String endTime;


  @ApiModelProperty(value="连接结果")
  private Integer LinkStatusNum;

  @ApiModelProperty(value="终端类型")
  private String dldDevtype;


  @ApiModelProperty(value="设备厂商")
  private String dldMfginfo;

  @ApiModelProperty(value="系统名称")
  private String dloDistro;

  @ApiModelProperty(value="升级类型")
  private Integer upgradeType;
}
