package com.cloud.platform.entity.device;

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
 * 设备档案
 * </p>
 *
 * @author byl
 * @since 2022-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_archives")
@ApiModel(value="DeviceArchives对象", description="设备档案")
public class DeviceArchives implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "da_id", type = IdType.ASSIGN_ID)
    private String daId;

    @ApiModelProperty(value = "设备编号")
    @TableField("da_deviceId")
    private String deviceId;

    @ApiModelProperty(value = "系统名称")
    @TableField("da_sys_name")
    private String sysName;

    @ApiModelProperty(value = "系统类型")
    @TableField("da_sys_type")
    private String sysType;

    @ApiModelProperty(value = "系统版本")
    @TableField("da_sys_version")
    private String sysVersion;

    @ApiModelProperty(value = "产权单位")
    @TableField("da_unit")
    private String unit;

    @ApiModelProperty(value = "所在区域")
    @TableField("da_address")
    private String address;

    @ApiModelProperty(value = "设备类型")
    @TableField("da_device_type")
    private String deviceType;

    @ApiModelProperty(value = "设备型号")
    @TableField("da_device_version")
    private String deviceVersion;

    @ApiModelProperty(value = "设备厂商")
    @TableField("da_device_mfgInfo")
    private String deviceMfginfo;

    @ApiModelProperty(value = "设备地址")
    @TableField("da_device_address")
    private String deviceAddress;

    @ApiModelProperty(value = "经度")
    @TableField("da_device_longitude")
    private String deviceLongitude;

    @ApiModelProperty(value = "纬度")
    @TableField("da_device_latitude")
    private String deviceLatitude;

    @ApiModelProperty(value = "通信类型")
    @TableField("da_cmt_type")
    private String cmtType;

    @ApiModelProperty(value = "通信规约")
    @TableField("da_cmt_statute")
    private String cmtStatute;

    @ApiModelProperty(value = "通信协议")
    @TableField("da_cmt_agreed")
    private String cmtAgreed;

    @ApiModelProperty(value = "终端通信地址")
    @TableField("da_cmt_address")
    private String cmtAddress;

    @ApiModelProperty(value = "终端地址标识")
    @TableField("da_cmt_add_label")
    private String cmtAddLabel;

    @ApiModelProperty(value = "主站ip")
    @TableField("da_master_ip")
    private String masterIp;

    @ApiModelProperty(value = "主站端口")
    @TableField("da_master_port")
    private String masterPort;

    @ApiModelProperty(value = "负责人")
    @TableField("da_principal")
    private String principal;

    @ApiModelProperty(value = "是否新标")
    @TableField("da_isNew")
    private String isNew;

    @ApiModelProperty(value = "联系电话")
    @TableField("da_phone")
    private String phone;

    @ApiModelProperty(value = "档案状态")
    @TableField("da_state")
    private String state;

    @ApiModelProperty(value = "备注")
    @TableField("da_remark")
    private String remark;

    @ApiModelProperty(value = "认证状态 0-已认证成功 1-未认证成功")
    @TableField(exist = false)
    private String authState;

    @ApiModelProperty(value = "连接状态")
    @TableField(exist = false)
    private String linkStatusNum;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("da_editTime")
    private Date editTime;

    @ApiModelProperty(value = "建档时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("da_createTime")
    private Date createTime;
}
