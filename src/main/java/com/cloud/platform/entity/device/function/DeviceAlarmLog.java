package com.cloud.platform.entity.device.function;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备告警事件
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_alarm_log")
@ApiModel(value="DeviceAlarmLog对象", description="设备告警事件")
public class DeviceAlarmLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dae_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "设备id ")
    @TableField("dae_deviceId")
    private String deviceId;

    @ApiModelProperty(value = "t_device_alarm_code表id")
    @TableField("dae_event")
    private String event;

    @ApiModelProperty(value = "事件描述")
    @TableField("dae_msg")
    private String msg;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dae_createTime")
    private Date createTime;


}
