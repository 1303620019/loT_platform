package com.cloud.platform.entity.device.market;

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
 * 系统补丁信息表
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_patch")
@ApiModel(value="DevicePatch对象", description="系统补丁信息表")
public class DevicePatch implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dp_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "版本号")
    @TableField("dp_versions")
    private String versions;

    @ApiModelProperty(value = "发布单位")
    @TableField("dp_putUnit")
    private String putUnit;

    @ApiModelProperty(value = "联系人")
    @TableField("dp_contact")
    private String contact;

    @ApiModelProperty(value = "联系人电话")
    @TableField("dp_phone")
    private String phone;

    @ApiModelProperty(value = "系统名称")
    @TableField("dp_sysName")
    private String sysName;

    @ApiModelProperty(value = "系统类型")
    @TableField("dp_sysType")
    private String sysType;

    @ApiModelProperty(value = "补丁名称")
    @TableField("dp_name")
    private String name;

    @ApiModelProperty(value = "补丁类型 ")
    @TableField("dp_paType")
    private Integer paType;

    @ApiModelProperty(value = "补丁状态 ")
    @TableField("dp_state")
    private Integer state;

    @ApiModelProperty(value = "补丁文件id")
    @TableField("dp_patchFileId")
    private String patchFileId;
    @ApiModelProperty(value = "检测报告名称")
    @TableField("dp_examFileName")
    private String examFileName;

    @ApiModelProperty(value = "检测报告")
    @TableField("dp_examFileId")
    private String examFileId;
    @ApiModelProperty(value = "验证文件id")
    @TableField(exist = false)
    private String signFileId;

    @ApiModelProperty(value = "验证文件名称")
    @TableField(exist = false)
    private String signName;

    @ApiModelProperty(value = "检测单位")
    @TableField("dp_examUnit")
    private String examUnit;

    @ApiModelProperty(value = "备注")
    @TableField("dp_remark")
    private String remark;

    @ApiModelProperty(value = "检测时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dp_examTime")
    private Date examTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dp_editTime")
    private Date editTime;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dp_createTime")
    private Date createTime;


}
