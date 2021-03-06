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
 * 表Cpu
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_cpu")
@ApiModel(value="DeviceLinkCpu对象", description="表Cpu")
public class DeviceLinkCpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dld_id", type = IdType.ASSIGN_ID)
    private String dldId;

    @ApiModelProperty(value = "t_device_link_dev 表id")
    @TableField("dld_dli_id")
    private String dldDliId;

    @ApiModelProperty(value = "CPU 核数")
    @TableField("dlc_cpus")
    private Integer dlcCpus;

    @ApiModelProperty(value = "CPU 主频 GHz 为单位")
    @TableField("dlc_frequency")
    private String dlcFrequency;

    @ApiModelProperty(value = "CPU 缓存以 MB/核为单位")
    @TableField("dlc_cache")
    private Integer dlcCache;

    @ApiModelProperty(value = "CPU 架构")
    @TableField("dlc_arch")
    private String dlcArch;

    @ApiModelProperty(value = "CPU 监控阈值")
    @TableField("dlc_cpuLmt")
    private Integer dlcCpulmt;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dlc_createTime")
    private Date dlcCreatetime;


}
