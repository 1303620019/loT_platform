package com.cloud.platform.req;


import com.cloud.platform.comm.BaseRequest;
import com.cloud.platform.entity.device.DeviceRestartLog;
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
@ApiModel(value = "DeviceRestartLogREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceRestartLogREQ extends BaseRequest<DeviceRestartLog> {

  @ApiModelProperty(value = "设备编号")
  private String deviceId;

}
