package com.cloud.platform.req;

import com.cloud.platform.comm.BaseRequest;
import com.cloud.platform.entity.device.function.DeviceFunctionInfo;
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
@ApiModel(value = "FunctionREQ对象", description = "运行查询对象")
@Data
@Accessors(chain = true)
public class FunctionREQ extends BaseRequest<DeviceFunctionInfo> {

  @ApiModelProperty(value="设备编号")
  private String deviceId;

  @ApiModelProperty(value="运行状态")
  private String onLineState;

  @ApiModelProperty(value="请求集合mid")
  public String  mids;

  @ApiModelProperty(value="请求类型集合")
  public String types;
}
