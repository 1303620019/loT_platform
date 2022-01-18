package com.cloud.platform.entity.device;

import com.alibaba.fastjson.annotation.JSONField;
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
 *  数字签证信息
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_file_sign")
@ApiModel(value="DeviceLinkFileSign对象", description=" 数字签证信息")
public class DeviceLinkFileSign implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dls_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String dlsId;

    @ApiModelProperty(value = "数字证书文件名字")
    @TableField("dls_name")
    private String name;

    @ApiModelProperty(value = " 数字证书文件路径")
    @TableField("dls_url")
    private String url;

    @ApiModelProperty(value = "文件的大小")
    @TableField("dls_size")
    private Integer size;

    @ApiModelProperty(value = "数字证书文件的 md5 值，用于校验文件")
    @TableField("dls_md5")
    private String md5;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("dls_createTime")
    @JSONField(serialize=false)
    private Date dlsCreatetime;


}
