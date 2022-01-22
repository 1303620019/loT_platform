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
 * 硬盘阈值信息
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_cfgdisk")
@ApiModel(value="DeviceLinkCfgdisk对象", description="硬盘阈值信息")
public class DeviceLinkCfgdisk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dlcm_id", type = IdType.ASSIGN_ID)
    private String dlcmId;

    @ApiModelProperty(value = "t_device_link_info表id")
    @TableField("dlcm_dli_id")
    private String dlcmDliId;

    @ApiModelProperty(value = "内存限值,单位：M Byte")
    @TableField("dlcd_disk")
    private Integer dlcdDisk;

    @ApiModelProperty(value = "内存监控阈值，百分数")
    @TableField("dlcd_memLmt")
    private Integer dlcdMemlmt;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dlcd_createTime")
    private Date dlcdCreatetime;


}
