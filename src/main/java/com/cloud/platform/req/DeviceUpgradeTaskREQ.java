package com.cloud.platform.req;


import com.cloud.platform.comm.BaseRequest;
import com.cloud.platform.entity.device.plan.DeviceUpgradeTask;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.req
 * @author:byl
 * @createTime:2022/1/14 16:01
 * @version:1.0
 */
@ApiModel(value = "DeviceUpgradeTaskREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceUpgradeTaskREQ extends BaseRequest<DeviceUpgradeTask> {

  @ApiModelProperty("起始时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  public Date startTime;

  @ApiModelProperty("终止时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  public Date endTime;

  @ApiModelProperty(value = "0-立即执行  1-定时执行")
  public Integer execType;

  @ApiModelProperty(value = "0-保存 1-下发  2-执行   3-已执行")
  public Integer state;

  @ApiModelProperty(value = "0-设备 1-容器 2-系统")
  public Integer type;

  @ApiModelProperty(value = "执行状态")
  private String exceState;

  @ApiModelProperty(value = "计划编号")
  private String num;

  @ApiModelProperty(value = "设备档案表的ID")
  private String arcId;

  @ApiModelProperty(value = "计划名称")
  private String name;

  @ApiModelProperty(value = "计划内容")
  public DeviceUpgradeTask field;

  @ApiModelProperty(value = "设备集合")
  public List<String> daIds;
  @ApiModelProperty(value = "设备档案id")
  public String daId;
}
