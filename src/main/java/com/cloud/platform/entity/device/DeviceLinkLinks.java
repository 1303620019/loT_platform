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
 * 外接设备信息
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_links")
@ApiModel(value="DeviceLinkLinks对象", description="外接设备信息")
public class DeviceLinkLinks implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dll_id", type = IdType.ASSIGN_ID)
    private String dllId;

    @ApiModelProperty(value = "t_device_link_dev 表id")
    @TableField("dll_dli_id")
    private String dllDliId;

    @ApiModelProperty(value = "接口的类型，如以太网口、4G、“Ethernet”、”4G“")
    @TableField("dll_type")
    private String dllType;

    @ApiModelProperty(value = "接口的 ID，主要用于 HPLC 和 4G 等外部模块")
    @TableField("dllin_id")
    private String dllinId;

    @ApiModelProperty(value = "接口的名称如为以太网口、4G，则形如“eth1”、”ppp-0”")
    @TableField("dll_name")
    private String dllName;

    @ApiModelProperty(value = "如接口为以太网、4G，则添加 mac 地址，形如“B8-85-74-15-A5-3E”")
    @TableField("dll_mac")
    private String dllMac;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dll_createTime")
    private Date dllCreatetime;


}
