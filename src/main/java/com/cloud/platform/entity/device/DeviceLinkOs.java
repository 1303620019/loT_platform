package com.cloud.platform.entity.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 操作系统信息
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_os")
@ApiModel(value="DeviceLinkOs对象", description="操作系统信息")
public class DeviceLinkOs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dlo_id", type = IdType.ASSIGN_ID)
    private String dloId;

    @ApiModelProperty(value = "t_device_link_dev 表id")
    @TableField("dlo_dle_id")
    private String dloDlDId;
    @ApiModelProperty(value = "dlo_deviceId")
    @TableField("dlo_deviceId")
    private String dloDeviceId;
    @ApiModelProperty(value = "操作系统名称，如“Ubunut”“Redhat”")
    @TableField("dlo_distro")
    private String dloDistro;

    @ApiModelProperty(value = "操作系统版本，如“18.10”")
    @TableField("dlo_version")
    private String dloVersion;

    @ApiModelProperty(value = "操作系统内核，如“3.10-17”")
    @TableField("dlo_kernel")
    private String dloKernel;

    @ApiModelProperty(value = "平台软件组件版本，如“V01.024”")
    @TableField("dlo_softVersion")
    private String dloSoftversion;

    @ApiModelProperty(value = " 平台软件组件补丁版本，如“PV01.0001”")
    @TableField("dlo_patchVersion")
    private String dloPatchversion;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dlo_createTime")
    private Date dloCreatetime;


    @ApiModelProperty(value = "终端连接状态")
    @TableField(exist = false)
    private Integer dldDevStatusNum;


    @ApiModelProperty(value = "终端硬件版本号")
    @TableField(exist = false)
    private String dldHardversion;


    @ApiModelProperty(value = "终端厂商信息")
    @TableField(exist = false)
    private String dldMfginfo;

    @ApiModelProperty(value = "终端名称")
    @TableField(exist = false)
    private String dldDevname;

    @ApiModelProperty(value = "终端类型")
    @TableField(exist = false)
    private String dldDevtype;

}
