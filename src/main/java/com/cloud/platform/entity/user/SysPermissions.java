package com.cloud.platform.entity.user;

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
 * 
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysPermissions对象", description="")
public class SysPermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer pid;

    private String url;

    private String perms;

    private String icon;

    @ApiModelProperty(value = "类型 0目录 1菜单 2按钮")
    private Integer type;

    @ApiModelProperty(value = "0隐藏,1显示")
    private Integer isShow;

    private Integer orderNum;

    private Date createTime;

    private Date updateTime;


}
