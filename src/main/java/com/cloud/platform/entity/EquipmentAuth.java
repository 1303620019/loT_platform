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
 * 登录认证表
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_equipment_auth")
@ApiModel(value="EquipmentAuth对象", description="登录认证表")
public class EquipmentAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ea_id", type = IdType.ASSIGN_ID)
    private String eaId;

    @ApiModelProperty(value = "登录名称")
    @TableField("ea_username")
    private String eaUsername;

    @ApiModelProperty(value = "登录密码")
    @TableField("ea_password")
    private String eaPassword;

    @ApiModelProperty(value = "客户端id")
    @TableField("ea_client_id")
    private String eaClientId;

    @ApiModelProperty(value = "状态 0-正常 1-删除")
    @TableField("ea_state")
    private Integer eaState;

    @ApiModelProperty(value = "创建时间")
    @TableField("ea_create_time")
    private String eaCreateTime;


}
