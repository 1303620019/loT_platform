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
 * 阈值信息Cpu
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_cfgcpu")
@ApiModel(value="DeviceLinkCfgcpu对象", description="阈值信息Cpu")
public class DeviceLinkCfgcpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dlcpu_id", type = IdType.ASSIGN_ID)
    private String dlcpuId;

    @ApiModelProperty(value = "t_device_link_info表id")
    @TableField("dlo_kernel")
    private String dlcpuDliId;

    @ApiModelProperty(value = "CPU 核数(例如值为 2，3，4)")
    @TableField("dlcpu_cpus")
    private Integer dlcpuCpus;

    @ApiModelProperty(value = "CPU 监控阈值")
    @TableField("dlcpu_cpuLmt")
    private Integer dlcpuCpulmt;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dlcpu_createTime")
    private Date dlcpuCreatetime;


}
