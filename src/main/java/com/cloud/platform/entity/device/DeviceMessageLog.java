package com.cloud.platform.entity.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 消息记录
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_message_log")
@ApiModel(value="DeviceMessageLog对象", description="消息记录")
public class DeviceMessageLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dml_id", type = IdType.ASSIGN_ID)
    private String dmlId;

    @ApiModelProperty(value = "登录用户名")
    private String dmlUsername;

    @ApiModelProperty(value = "主题名称")
    private String dmlTopic;

    @ApiModelProperty(value = "消息体")
    private String dmlPayload;

    @ApiModelProperty(value = "事件触发时间")
    private String dmlTimestamp;

    @ApiModelProperty(value = "消息到达 Broker 的时间")
    private String dmlPublishReceivedAt;

    @ApiModelProperty(value = "消息等级")
    private String dmlQos;

    @ApiModelProperty(value = "客户端的 IPAddress")
    private String dmlPeerhost;

    @ApiModelProperty(value = "事件触发所在节点")
    private String dmlNode;

    @ApiModelProperty(value = "客户端id")
    private String dmlClientid;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dml_createTime")
    @JSONField(serialize=false)
    private Date createTime;
}
