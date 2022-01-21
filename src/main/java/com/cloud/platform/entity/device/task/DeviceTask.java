package com.cloud.platform.entity.device.task;

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
 * 计划任务关系表
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_task")
@ApiModel(value="DeviceTask对象", description="计划任务关系表")
public class DeviceTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dt_id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "t_device_archives表id")
    @TableField("dt_arcId")
    private String arcId;

    @ApiModelProperty(value = "t_device_archives表id")
    @TableField("dt_taId")
    private String taId;

    @ApiModelProperty(value = "0-保存 1-下发  2-执行   3-已执行")
    @TableField("dt_state")
    private Integer state;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dt_creataTime")
    private Date creataTime;


}
