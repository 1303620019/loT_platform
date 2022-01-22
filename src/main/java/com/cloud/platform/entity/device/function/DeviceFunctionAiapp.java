package com.cloud.platform.entity.device.function;

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
 * Ai运行信息
 * </p>
 *
 * @author byl
 * @since 2022-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_function_aiapp")
@ApiModel(value="DeviceFunctionAiapp对象", description="Ai运行信息")
public class DeviceFunctionAiapp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dfa_id", type = IdType.ASSIGN_ID)
    private String dfaId;

    @ApiModelProperty(value = "设备id")
    @TableField("dfa_deviceId")
    private String dfaDeviceid;

    @ApiModelProperty(value = "t_device_function_state表id")
    @TableField("dfa_dfiId")
    private String dfaDfiId;

    @ApiModelProperty(value = "Ai信息 例：app1, v1.0")
    @TableField("dfa_dfiId")
    private String dfaInfo;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dfa_createTime")
    private Date dfaCreatetime;


}
