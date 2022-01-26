package com.cloud.platform.entity.device.run;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 召回类型列表
 * </p>
 *
 * @author byl
 * @since 2022-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_recall")
@ApiModel(value="DeviceRecall对象", description="召回类型列表")
public class DeviceRecall implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dr_id", type = IdType.ASSIGN_ID)
    private String drId;

    @ApiModelProperty(value = "类型名称")
    private String dfName;
    @ApiModelProperty(value = "发送的事件")
    private String dfEvent;
    @ApiModelProperty(value = "指令信息")
    private String dfDirect;

    @ApiModelProperty(value = "创建时间")
    private Date dfCreate;


}
