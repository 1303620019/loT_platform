package com.cloud.platform.entity.device.function;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备运行状态
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_function_info")
@ApiModel(value="DeviceFunctionInfo对象", description="设备运行状态")
public class DeviceFunctionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dfi_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String id;

    @ApiModelProperty(value = "设备id")
    @TableField("dfi_deviceId")
    @JSONField(serialize=false)
    private String deviceId;

    @ApiModelProperty(value = "CPU 负载")
    @TableField("dfi_cpuRate")
    private Integer cpuRate;

    @ApiModelProperty(value = "t_device_function_mem表的id")
    @TableField("dfi_dfmId")
    @JSONField(serialize=false)
    private String dfmId;

    @ApiModelProperty(value = "磁盘占用率（例如 50.5 表示 50.5%）")
    @TableField("dfi_diskUsed")
    private Integer diskUsed;

    @ApiModelProperty(value = "主板（cpu）温度，单位：摄氏度℃")
    @TableField("dfi_tempValue")
    private Integer tempValue;

    @ApiModelProperty(value = "设备当前时间")
    @TableField("dfi_devDateTime")
    private String devDateTime;

    @ApiModelProperty(value = "设备最近一次启动时间")
    @TableField("dfi_devStDateTime")
    private String devStDateTime;

    @ApiModelProperty(value = "设备运行时长，单位：秒")
    @TableField("dfi_devRunTime")
    private Integer devRunTime;

    @ApiModelProperty(value = "dfi_id")
    @TableField("dfi_linkState")
    @JSONField(serialize=false)
    private String linkState;

    @ApiModelProperty(value = "地理位置信息经度")
    @TableField("dfi_longitude")
    private String longitude;

    @ApiModelProperty(value = "地理位置信息经度")
    @TableField("dfi_latitude")
    private String latitude;
    @ApiModelProperty(value = "创建时间")
    @TableField("dfi_createTime")
    @JSONField(serialize=false)
    private Date createTime;


}
