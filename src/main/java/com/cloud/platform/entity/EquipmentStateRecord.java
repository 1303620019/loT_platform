package com.cloud.platform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备连接表记录表
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_equipment_state_record")
@ApiModel(value="EquipmentStateRecord对象", description="设备连接表记录表")
public class EquipmentStateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "esr_id", type = IdType.ASSIGN_ID)
    private String esrId;

    @ApiModelProperty(value = "客户端id")
    @TableField("esr_client_id")
    private String esrClientId;

    @ApiModelProperty(value = "设备登录名称")
    @TableField("esr_username")
    private String esrUsername;

    @ApiModelProperty(value = "设备密码")
    @TableField("esr_password")
    private String esrPassword;

    @ApiModelProperty(value = "设备ip地址")
    @TableField("esr_ip_address")
    private String esrIpAddress;

    @ApiModelProperty(value = " 0:断开连接 1:建立连接")
    @TableField("esr_connect_type")
    private Integer esrConnectType;

    @ApiModelProperty(value = "创建时间")
    @TableField("esr_create_time")
    private Date esrCreateTime;

    @ApiModelProperty(value = "0-正常 1-删除")
    @TableField("esr_state")
    private Integer esrState;


}
