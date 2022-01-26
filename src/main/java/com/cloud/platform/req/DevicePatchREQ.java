package com.cloud.platform.req;


import com.cloud.platform.comm.BaseRequest;
import com.cloud.platform.entity.device.market.DevicePatch;
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
@ApiModel(value = "DevicePatchREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DevicePatchREQ extends BaseRequest<DevicePatch> {

  @ApiModelProperty(value = "补丁档案id")
  public String paId;

  @ApiModelProperty(value = "补丁名称")
  public String name;

  @ApiModelProperty(value = "补丁类型 ")
  public Integer type;

  @ApiModelProperty(value = "版本号")
  public String versions;

  @ApiModelProperty(value = "发布单位")
  public String putUnit;

  @ApiModelProperty(value = "系统名称")
  public String sysName;

  @ApiModelProperty(value = "系统类型")
  public String sysType;

  @ApiModelProperty(value = "记录状态")
  public Integer paState;


}
