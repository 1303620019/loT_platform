package com.cloud.platform.req;


import com.baomidou.mybatisplus.annotation.TableField;
import com.cloud.platform.base.BaseRequest;
import com.cloud.platform.entity.device.upgrade.DeviceUpgrade;
import com.cloud.platform.entity.device.upgrade.DeviceUpgradeSchedule;
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
@ApiModel(value = "DeviceUpgradeScheduleREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceUpgradeScheduleREQ extends BaseRequest<DeviceUpgradeSchedule>{
  @ApiModelProperty(value = "工作任务唯一id")
  private Integer jobId;
}
