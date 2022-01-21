package com.cloud.platform.req;


import com.cloud.platform.base.BaseRequest;
import com.cloud.platform.entity.device.task.DeviceUpgradeTask;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;
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
@ApiModel(value = "DeviceUpgradeREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceUpgradeREQ extends BaseRequest<DeviceUpgrade>{
  @ApiModelProperty(value = "升级命令内容")
  public DeviceUpgrade field;
  @ApiModelProperty(value = "升级设备集合")
  public List<String> deviceIds;

}
