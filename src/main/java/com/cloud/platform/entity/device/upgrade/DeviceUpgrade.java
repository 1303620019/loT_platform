package com.cloud.platform.entity.device.upgrade;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.platform.entity.device.DeviceLinkFile;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 设备升级信息表
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_upgrade")
@ApiModel(value="DeviceUpgrade对象", description="设备升级信息")
public class DeviceUpgrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "du_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String duId;

    @ApiModelProperty(value = "工作任务id")
    @TableField("du_jobId")
    private Integer jobId;

    @ApiModelProperty(value = "补丁名称")
    @TableField(exist = false)
    private String paName;

    @ApiModelProperty(value = "升级间隔开始时间 null||0-立即升级  单位：秒")
    @TableField("du_policy")
    private Integer policy;

    @ApiModelProperty(value = "升级后的版本号")
    @TableField("du_version")
    private String version;

    @ApiModelProperty(value = "0 表示补丁升级 1 表示文件系统升级 2 表示内核升级 3 表示全量升级（文件系统+内核升级）")
    @TableField("du_upgradeType")
    private Integer upgradeType;

    @ApiModelProperty(value = "t_device_link_file表id ")
    @TableField("du_fileId")
    @JSONField(serialize=false)
    private String duFileId;

    @ApiModelProperty(value = "设备编号")
    @TableField("du_deviceId")
    @JSONField(serialize=false)
    private String deviceId;

    @ApiModelProperty(value = "t_device_upgrade_task表id")
    @TableField("du_taId")
    @JSONField(serialize=false)
    private String taId;

    @ApiModelProperty(value = "0-未执行 1-已执行")
    @TableField("du_exceState")
    @JSONField(serialize=false)
    private Integer exceState;

    @ApiModelProperty(value = "设备升级进度")
    @TableField("du_progress")
    @JSONField(serialize=false)
    private Integer progress;
    @ApiModelProperty(value = "升级结果")
    @TableField("du_result")
    @JSONField(serialize=false)
    private Integer resultState;

    @ApiModelProperty(value = "在线状态")
    @TableField(exist = false)
    @JSONField(serialize=false)
    private Integer linkState;

    @ApiModelProperty(value = "1：待下载  2：下载中 3：待安装 4：安装中 5：安装完毕")
    @TableField("du_state")
    @JSONField(serialize=false)
    private Integer state;

    @ApiModelProperty(value = "升级备注")
    @TableField("du_remark")
    @JSONField(serialize=false)
    private String remark;

    @ApiModelProperty(value = "升级结果描述")
    @TableField("du_msg")
    @JSONField(serialize=false)
    private String msg;

    @ApiModelProperty(value = "升级文件")
    @TableField(exist = false)
    private DeviceLinkFile file;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("du_createTime")
    @JSONField(serialize=false)
    private Date createTime;

    @ApiModelProperty(value = "升级计划名称")
    @TableField("du_name")
    @JSONField(serialize=false)
    private String name;


}
