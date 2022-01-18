package com.cloud.platform.entity.device.function;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 内存使用信息
 * </p>
 *
 * @author byl
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_function_mem")
@ApiModel(value="DeviceFunctionMem对象", description="内存使用信息")
public class DeviceFunctionMem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dfm_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String id;

    @ApiModelProperty(value = "占用的物理内存 （例如 50 表示 50%）")
    @TableField("dfm_phy")
    private Integer phy;

    @ApiModelProperty(value = "占用的虚拟内存（例如 50 表示 50%）")
    @TableField("dfm_virt")
    private Integer virt;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dfm_createTime")
    @JSONField(serialize=false)
    private Date createTime;

}
