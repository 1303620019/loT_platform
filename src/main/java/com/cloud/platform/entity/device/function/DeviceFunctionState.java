package com.cloud.platform.entity.device.function;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 接口运行状态
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_function_state")
@ApiModel(value="DeviceFunctionState对象", description="接口运行状态")
public class DeviceFunctionState implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dfs_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String id;

    @ApiModelProperty(value = "t_device_function_info表的id")
    @TableField("dfs_dfiId")
    @JSONField(serialize=false)
    private String dfiId;

    @ApiModelProperty(value = "接口的名称")
    @TableField("dfs_name")
    private String name;

    @ApiModelProperty(value = "设备接口状态")
    @TableField("dfs_status")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dfs_createTime")
    @JSONField(serialize=false)
    private Date createTime;
}
