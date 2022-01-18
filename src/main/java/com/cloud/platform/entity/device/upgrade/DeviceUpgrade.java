package com.cloud.platform.entity.device.upgrade;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.platform.entity.device.DeviceLinkFile;
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

    @ApiModelProperty(value = "设备升级进度")
    @TableField("du_progress")
    @JSONField(serialize=false)
    private Integer progress;


    @ApiModelProperty(value = "1：待下载  2：下载中 3：待安装 4：安装中 5：安装完毕")
    @TableField("du_state")
    @JSONField(serialize=false)
    private Integer state;


    @ApiModelProperty(value = "升级结果描述")
    @TableField("du_msg")
    @JSONField(serialize=false)
    private String msg;
    @ApiModelProperty(value = "升级文件")
    @TableField(exist = false)
    private DeviceLinkFile file;


    @ApiModelProperty(value = "创建时间")
    @TableField("du_createTime")
    @JSONField(serialize=false)
    private Date createTime;
}
