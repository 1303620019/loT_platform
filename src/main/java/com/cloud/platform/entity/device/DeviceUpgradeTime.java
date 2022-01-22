package com.cloud.platform.entity.device;

import com.alibaba.fastjson.annotation.JSONField;
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
 * 时间同步记录
 * </p>
 *
 * @author byl
 * @since 2022-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_upgrade_time")
@ApiModel(value="DeviceUpgradeTime对象", description="时间同步记录")
public class DeviceUpgradeTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dut_id", type = IdType.ASSIGN_ID)
    private String dutId;

    @ApiModelProperty(value = "请求id")
    @TableField("dut_mid")
    @JSONField(serialize=false)
    private Integer dutMid;

    @ApiModelProperty(value = "日期和时间参数")
    @TableField("dut_time")
    private String dateTime;

    @ApiModelProperty(value = "时区")
    @TableField("dut_Zone")
    private String timeZone;

    @ApiModelProperty(value = "创建时间")
    @TableField("dut_dusCreateTime")
    @JSONField(serialize=false)
    private Date dutDuscreatetime;


}
