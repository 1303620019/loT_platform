package com.cloud.platform.req;


import com.cloud.platform.comm.BaseRequest;
import com.cloud.platform.entity.device.run.DeviceBatchInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.req
 * @author:byl
 * @createTime:2022/1/14 16:01
 * @version:1.0
 */
@ApiModel(value = "DeviceBatchInfoREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceBatchInfoREQ extends BaseRequest<DeviceBatchInfo> {

  @ApiModelProperty(value = "批次名称")
  public  String dbiName;
  @ApiModelProperty(value = "巡测时间起")
  public  String startTime;

  @ApiModelProperty(value = "巡测时间止")
  public  String endTime;

  @ApiModelProperty(value = "设备集合")
  public List<String> daIds;

  @ApiModelProperty(value = "召回类型集合")
  public  List<String> recalls;
}
