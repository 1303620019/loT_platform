package com.cloud.platform.entity;

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
 * 设备表
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_equipment")
@ApiModel(value="Equipment对象", description="设备表")
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "eu_id", type = IdType.ASSIGN_ID)
    private String euId;

    @ApiModelProperty(value = "t_equipment_auth表id")
    @TableField("eu_eaId")
    private String euEaid;

    @ApiModelProperty(value = "设备编号")
    private String euNumber;

    @ApiModelProperty(value = "设备型号")
    private String euModel;

    @ApiModelProperty(value = "设备类型")
    private String euType;

    @ApiModelProperty(value = "登录权限 0-可以 1-不可")
    private Integer euPower;

    @ApiModelProperty(value = "设备ip地址")
    private String euIpAddress;

    @ApiModelProperty(value = "设备厂家")
    private String euManufactor;

    @ApiModelProperty(value = "设备出厂时间")
    private Date euEquipmentTime;

    @ApiModelProperty(value = "档案状态 0-正常 1-删除")
    private Integer euState;

    @ApiModelProperty(value = "创建时间")
    private Date euCreateTime;


}
