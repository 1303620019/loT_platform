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
 * 主动上报的上报时间间隔
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_function_temperature")
@ApiModel(value="DeviceFunctionTemperature对象", description="主动上报的上报时间间隔")
public class DeviceFunctionTemperature implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "dft_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String id;

    @ApiModelProperty(value = "设备id")
    @TableField("dft_deviceId")
    @JSONField(serialize=false)
    private String deviceId;

    @ApiModelProperty(value = "t_device_link_dev表的id ")
    @JSONField(serialize=false)
    @TableField("dft_devId")
    private String devId;

    @ApiModelProperty(value = "主板温度监控低温阈值")
    @TableField("dft_temLow")
    private Integer temLow;

    @ApiModelProperty(value = "主板温度监控高温阈值")
    @TableField("dft_temHigh")
    private Integer temHigh;


    @ApiModelProperty(value = "创建时间")
    @TableField("dft_createTime")
    @JSONField(serialize=false)
    private Date createTime;
}
