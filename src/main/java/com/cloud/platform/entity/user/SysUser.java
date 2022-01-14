package com.cloud.platform.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysUser对象", description="")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String email;

    private String phone;

    @ApiModelProperty(value = "状态 0锁定 1有效")
    private String state;

    @ApiModelProperty(value = "性别 0男 1女")
    private String sex;

    @ApiModelProperty(value = "个人描述")
    private String remarks;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;
    //数据库不存在这个字段
    @TableField(exist = false)
    private List<SysPermissions> permissionsList;
}
