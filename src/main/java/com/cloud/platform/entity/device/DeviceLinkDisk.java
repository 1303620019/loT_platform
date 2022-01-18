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
 * 内存信息
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_disk")
@ApiModel(value="DeviceLinkMem对象", description="硬盘信息字段")
public class DeviceLinkDisk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dld_id", type = IdType.ASSIGN_ID)
    private String dldId;

    @ApiModelProperty(value = "t_device_link_dev 表id")
    private String dldDliId;

    @ApiModelProperty(value = "磁盘空间，以 M 为单位")
    private Integer dldDisk;

    @ApiModelProperty(value = "磁盘监控阈值，例如 50 表示 50%")
    @TableField("dld_diskLmt")
    private Integer dldDisklmt;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dld_createTime")
    private Date dldCreatetime;


}
