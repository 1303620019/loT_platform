package com.cloud.platform.entity.device.plan;

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
 * 计划任务表
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_upgrade_task")
@ApiModel(value="DeviceUpgradeTask对象", description="计划任务表")
public class DeviceUpgradeTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dut_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "计划名称")
    @TableField("dut_name")
    private String name;

    @ApiModelProperty(value = "计划编号")
    @TableField("dut_num")
    private String num;

    @ApiModelProperty(value = "0-未执行 1-待升级 2-已升级")
    @TableField("dut_exceState")
    private Integer exceState;

    @ApiModelProperty(value = "0-立即执行  1-定时执行")
    @TableField("dut_execType")
    private Integer execType;

    @ApiModelProperty(value = "0-设备 1-容器 2-系统")
    @TableField("dut_type")
    private Integer type;

    @ApiModelProperty(value = "执行时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dut_execTime")
    private Date execTime;


    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dut_editTime")
    private Date editTime;

    @ApiModelProperty(value = "t_device_patch表的id")
    @TableField("dut_paId")
    private String paId;

    @ApiModelProperty(value = "补丁名称")
    @TableField("dut_paName")
    private String paName;

    @ApiModelProperty(value = "补丁类型")
    @TableField("dut_paType")
    private Integer paType;

    @ApiModelProperty(value = "升级类型")
    @TableField("dut_upgradeType")
    private Integer upgradeType;

    @ApiModelProperty(value = "补丁版本")
    @TableField("dut_versions")
    private String versions;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dut_creataTime")
    private Date creataTime;

    @ApiModelProperty(value = "统计值")
    @TableField(exist = false)
    private String stat;
}
