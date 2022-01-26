package com.cloud.platform.entity.device.run;

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
 * 设备批次信息
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_function_batchInfo")
@ApiModel(value="DeviceBatchInfo对象", description="设备批次信息")
public class DeviceBatchInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dbi_id", type = IdType.ASSIGN_ID)
    private String dbiId;

    @ApiModelProperty(value = "批次名称 ")
    private String dbiName;

    @ApiModelProperty(value = "设备数量")
    private Integer dbiNum;

    @ApiModelProperty(value = "召回的类型列表")
    @TableField("dbi_recallType")
    private String dbiRecalltype;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dbi_createTime")
    private Date dbiCreatetime;


}
