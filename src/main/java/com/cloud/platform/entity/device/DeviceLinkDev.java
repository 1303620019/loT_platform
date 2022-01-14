package com.cloud.platform.entity.device;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备信息字段
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_dev")
@ApiModel(value="DeviceLinkDev对象", description="设备信息字段")
public class DeviceLinkDev implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dld_id", type = IdType.ASSIGN_ID)
    private String dldId;

    @ApiModelProperty(value = "t_device_link_info表id")
    private String dldDliId;

    @ApiModelProperty(value = "设备编号")
    private String dldDeviceId;
    @ApiModelProperty(value = "断开原因")
    private String  dldBreakReason;

    @ApiModelProperty(value = "终端类型")
    @TableField("dld_devType")
    private String dldDevtype;

    @ApiModelProperty(value = "终端名称")
    @TableField("dld_devName")
    private String dldDevname;

    @ApiModelProperty(value = "终端厂商信息")
    @TableField("dld_mfgInfo")
    private String dldMfginfo;

    @ApiModelProperty(value = "终端状态")
    @TableField("dld_devStatus")
    private String dldDevstatus;

    @ApiModelProperty(value = "终端连接状态")
    @TableField("dld_devStatus_num")
    private Integer dldDevStatusNum;

    @ApiModelProperty(value = "终端硬件版本号")
    @TableField("dld_hardVersion")
    private String dldHardversion;

    @ApiModelProperty(value = "创建时间")
    @TableField("dld_createTime")
    private Date dldCreatetime;


}
