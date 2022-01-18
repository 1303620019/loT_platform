package com.cloud.platform.entity.device.function;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 运行温度监控
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_function_repperiod")
@ApiModel(value="DeviceFunctionRepperiod对象", description="运行温度监控")
public class DeviceFunctionRepperiod implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "dfr_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String id;

    @ApiModelProperty(value = "设备id ")
    @JSONField(serialize=false)
    @TableField("dfr_deviceId")
    private String deviceId;
    @ApiModelProperty(value = "t_device_link_dev表的id ")
    @JSONField(serialize=false)
    @TableField("dfr_devId")
    private String devId;


    @ApiModelProperty(value = "终端状态主动上报的时间间隔，单位：秒")
    @TableField("dfr_devPeriod")
    private Integer devPeriod;

    @ApiModelProperty(value = "容器状态主动上报的时间间隔，单位：秒")
    @TableField("dfr_conPeriod")
    private Integer conPeriod;

    @ApiModelProperty(value = "APP 状态主动上报的时间间隔，单位：秒")
    @TableField("dfr_appPeriod")
    private Integer appPeriod;

    @ApiModelProperty(value = "终端应用层心跳上报的时间间隔,单位：秒")
    @TableField("dfr_heartPeriod")
    private Integer heartPeriod;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dfr_createTime")
    @JSONField(serialize=false)
    private Date createTime;
}
