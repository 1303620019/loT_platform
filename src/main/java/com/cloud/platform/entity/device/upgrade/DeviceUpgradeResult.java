package com.cloud.platform.entity.device.upgrade;

import com.alibaba.fastjson.annotation.JSONField;
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
 * 设备升级结果
 * </p>
 *
 * @author byl
 * @since 2022-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_upgrade_result")
@ApiModel(value="DeviceUpgradeResult对象", description="设备升级结果")
public class DeviceUpgradeResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dur_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "工作任务id")
    @TableField("dur_jobId")
    private Integer jobId;

    @ApiModelProperty(value = "设备id")
    @TableField("dur_deviceId")
    @JSONField(serialize = false)
    private String deviceId;

    @ApiModelProperty(value = "升级结果编码")
    @TableField("dur_code")
    private String code;

    @ApiModelProperty(value = "升级结果描述")
    @TableField("dur_msg")
    private String msg;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dur_createTime")
    @JSONField(serialize = false)
    private Date createTime;


}
