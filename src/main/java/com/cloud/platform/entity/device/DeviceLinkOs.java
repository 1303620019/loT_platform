package com.cloud.platform.entity.device;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
    private String dloDliId;

    @ApiModelProperty(value = "操作系统名称，如“Ubunut”“Redhat”")
    private String dloDistro;

    @ApiModelProperty(value = "操作系统版本，如“18.10”")
    private String dloVersion;

    @ApiModelProperty(value = "操作系统内核，如“3.10-17”")
    private String dloKernel;

    @ApiModelProperty(value = "平台软件组件版本，如“V01.024”")
    @TableField("dlo_softVersion")
    private String dloSoftversion;

    @ApiModelProperty(value = " 平台软件组件补丁版本，如“PV01.0001”")
    @TableField("dlo_patchVersion")
    private String dloPatchversion;

    @ApiModelProperty(value = "创建时间")
    @TableField("dlo_createTime")
    private Date dloCreatetime;


}
