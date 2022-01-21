package com.cloud.platform.entity.device.cfg;

import com.alibaba.fastjson.annotation.JSONField;
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
 * 配置管理记录
 * </p>
 *
 * @author byl
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_cfg_log")
@ApiModel(value="DeviceCfgLog对象", description="配置管理记录")
public class DeviceCfgLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dc_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "设备id  ")
    @TableField("dc_deviceId")
    @JSONField(serialize = false)
    private String deviceId;

    @ApiModelProperty(value = "设备名称  ")
    @TableField("dc_devName")
    private String devName;

    @ApiModelProperty(value = "系统cpu使用率上限阀值")
    @TableField("dc_cpu")
    private Integer cpuLmt;

    @ApiModelProperty(value = "系统内存使用率上限阀值")
    @TableField("dc_memLmt")
    private Integer memLmt;

    @ApiModelProperty(value = "系统储存占用率上限阀值")
    @TableField("dc_diskLmt")
    private Integer diskLmt;

    @ApiModelProperty(value = "主板温度监控低温阀值")
    @TableField("dc_temLow")
    @JSONField(serialize = false)
    private Integer temLow;

    @ApiModelProperty(value = "主板温度监控高温阀值")
    @TableField("dc_temHigh")
    @JSONField(serialize = false)
    private Integer temHigh;

    @ApiModelProperty(value = "0-保存  1-下发  2-召回")
    @TableField("dc_type")
    @JSONField(serialize = false)
    private Integer type;

    @ApiModelProperty(value = "同步设备当前时间")
    @TableField("dc_synDateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(serialize = false)
    private Date synDateTime;

    @ApiModelProperty(value = "创建时间")
    @TableField("dc_createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(serialize = false)
    private Date createTime;

    @ApiModelProperty(value = "温度监控信息")
    @TableField(exist = false)
    private Object temperature;
}
