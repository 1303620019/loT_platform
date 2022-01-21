package com.cloud.platform.entity.device;

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
 * 设备重启记录
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_restart_log")
@ApiModel(value="DeviceRestartLog对象", description="设备重启记录")
public class DeviceRestartLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "drl_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize = false)
    private String id;

    @ApiModelProperty(value = "设备id ")
    @TableField("drl_deviceId")
    private String deviceId;

    @ApiModelProperty(value = "os-reboot：重启终端系统,edge-reboot：重启终端组件")
    @TableField("drl_action")
    private String action;

    @ApiModelProperty(value = "返回结果时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(serialize = false)
    @TableField("drl_result_time")
    private Date resultTime;

    @ApiModelProperty(value = "返回状态码")
    @JSONField(serialize = false)
    @TableField("drl_result_code")
    private String resultCode;

    @ApiModelProperty(value = "0-成功 1-失败")
    @JSONField(serialize = false)
    @TableField("drl_result_state")
    private Integer resultState;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("drl_createTime")
    @JSONField(serialize = false)
    private Date createTime;

}
