package com.cloud.platform.entity.device;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
    private String dldDliId;

    @ApiModelProperty(value = "CPU 核数")
    private Integer dlcCpus;

    @ApiModelProperty(value = "CPU 主频 GHz 为单位")
    private String dlcFrequency;

    @ApiModelProperty(value = "CPU 缓存以 MB/核为单位")
    private Integer dlcCache;

    @ApiModelProperty(value = "CPU 架构")
    private String dlcArch;

    @ApiModelProperty(value = "CPU 监控阈值")
    @TableField("dlc_cpuLmt")
    private Integer dlcCpulmt;

    @ApiModelProperty(value = "创建时间")
    @TableField("dlc_createTime")
    private Date dlcCreatetime;


}
