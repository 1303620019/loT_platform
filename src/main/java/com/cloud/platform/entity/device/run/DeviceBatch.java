package com.cloud.platform.entity.device.run;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备批次
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_batch")
@ApiModel(value="DeviceBatch对象", description="设备批次")
public class DeviceBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "批次id")
    @TableField("db_batchId")
    private String dbBatchid;

    @ApiModelProperty(value = "t_device_archives表的id")
    @TableField("db_arcId")
    private String dbArcid;

    @ApiModelProperty(value = "请求唯一的标识")
    @TableField("db_mid")
    private Integer dbMid;

    @ApiModelProperty(value = "召回类型")
    @TableField("db_type")
    private Integer dbType;

    @ApiModelProperty(value = "设备id")
    @TableField(exist = false)
    private String deviceId;

    @ApiModelProperty(value = "设备类型")
    @TableField(exist = false)
    private String deviceType;

    @TableField(exist = false)
    private String mids;

    @TableField(exist = false)
    private String types;

    @ApiModelProperty(value = "创建时间  ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("db_createTime")
    private Date dbCreatetime;


}
