package com.cloud.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *统一请求id
 * </p>
 *
 * @author byl
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_mid")
@ApiModel(value="Tmid对象", description="统一请求id")
public class Tmid implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    @TableField("m_msg")
    private String msg;

    @TableField("m_createTime")
    private Date createTime;
}
