package com.cloud.platform.entity.device.upgrade;

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
 * 升级进度表
 * </p>
 *
 * @author byl
 * @since 2022-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_upgrade_schedule")
@ApiModel(value="DeviceUpgradeSchedule对象", description="升级进度表")
public class DeviceUpgradeSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dus_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "工作任务唯一id")
    @TableField("dus_jobId")
    private Integer jobId;

    @ApiModelProperty(value = " 进度 %")
    @TableField("dus_progress")
    private Integer progress;

    @ApiModelProperty(value = " 状态")
    @TableField("dus_progress")
    private Integer state;

    @ApiModelProperty(value = "创建时间  ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dus_createTime")
    private Date createTime;


}
