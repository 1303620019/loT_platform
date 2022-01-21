package com.cloud.platform.req;


import com.baomidou.mybatisplus.annotation.TableField;
import com.cloud.platform.base.BaseRequest;
import com.cloud.platform.entity.device.DeviceArchives;
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
@ApiModel(value = "DeviceArchivesREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class DeviceArchivesREQ extends BaseRequest<DeviceArchives> {

  @ApiModelProperty(value = "设备编号")
  private String deviceId;
  @ApiModelProperty(value = "设备类型")
  private String deviceType;
  @ApiModelProperty(value = "升级类型")
  private String upgradeType;
  @ApiModelProperty(value = "系统名称")
  private String sysName;
  @ApiModelProperty(value = "设备型号")
  private String deviceVersion;
  @ApiModelProperty(value = "设备厂商")
  private String deviceMfginfo;
  @ApiModelProperty(value = "在线状态")
  private String linkStatusNum;
  @ApiModelProperty(value = "终端通信地址")
  private String cmtAddress;

}
