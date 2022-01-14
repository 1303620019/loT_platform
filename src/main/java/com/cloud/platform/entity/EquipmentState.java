package com.cloud.platform.entity;

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
 * 设备连接表
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_equipment_state")
@ApiModel(value="EquipmentState对象", description="设备连接表")
public class EquipmentState implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "es_id", type = IdType.ASSIGN_ID)
    private String esId;

    @ApiModelProperty(value = "客户端id")
    private String esClientId;

    @ApiModelProperty(value = "0:断开连接 1:建立连接")
    private Integer esConnectType;

    @ApiModelProperty(value = "0:未知设备 1:正常设备")
    private Integer esAuthState;

    @ApiModelProperty(value = "创建时间")
    private Date esCreateTime;

    @ApiModelProperty(value = "状态 0-正常 1-删除")
    private Integer esState;


}
