package com.cloud.platform.entity.device;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * AI模块信息
 * </p>
 *
 * @author byl
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_ai")
@ApiModel(value="DeviceLinkAi对象", description="AI模块信息")
public class DeviceLinkAi implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dla_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "t_device_link_dev表的id")
    @TableField("dla_dldId")
    private String dldId;

    @ApiModelProperty(value = "AI模块型号")
    private String model;

    @ApiModelProperty(value = "AI模块算力，单位为TOPS")
    private Integer ops;

    @ApiModelProperty(value = "设备id  ")
    @TableField("dla_deviceId")
    private String deviceId;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dla_createTime")
    private Date createTime;


}
