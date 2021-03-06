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
 * 设备主信息表
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_info")
@ApiModel(value="DeviceLinkInfo对象", description="设备主信息表")
public class DeviceLinkInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dil_id", type = IdType.ASSIGN_ID)
    private String dilId;

    @ApiModelProperty(value = "该值为应答所对应请求报文的请求 ID")
    @TableField("dil_mid")
    private Integer dilMid;

    @ApiModelProperty(value = "边设备唯一标识")
    @TableField("dil_deviceId")
    private String dilDeviceid;

    @ApiModelProperty(value = "消息发送的时间戳")
    @TableField("dil_timestamp")
    private String dilTimestamp;

    @ApiModelProperty(value = "消息类型")
    @TableField("dil_type")
    private String dilType;

    @ApiModelProperty(value = "请求状态码")
    @TableField("dil_code")
    private String dilCode;

    @ApiModelProperty(value = "应答结果描述")
    @TableField("dil_msg")
    private String dilMsg;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dil_createTime")
    private Date dilCreatetime;


}
