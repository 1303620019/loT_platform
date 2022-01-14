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
 * 文件信息
 * </p>
 *
 * @author byl
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device_link_file")
@ApiModel(value="DeviceLinkFile对象", description="文件信息")
public class DeviceLinkFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dlf_id", type = IdType.ASSIGN_ID)
    @JSONField(serialize=false)
    private String dlfId;

    @ApiModelProperty(value = "文件的名字")
    @TableField("dlf_name")
    private String name;

    @ApiModelProperty(value = "文件的类型")
    @TableField("dlf_fileType")
    private String filetype;

    @ApiModelProperty(value = "文件路径")
    @TableField("dlf_url")
    private String url;

    @ApiModelProperty(value = "文件的大小")
    @TableField("dlf_size")
    private Integer size;

    @ApiModelProperty(value = "文件的 md5 值，用于校验文件")
    @TableField("dlf_md5")
    private String md5;

    @ApiModelProperty(value = "t_device_link_file_sign 表的id")
    @TableField("dlf_dlfs_id")
    @JSONField(serialize=false)
    private String fsId;

    @ApiModelProperty(value = "创建时间")
    @TableField("dlf_createTime")
    @JSONField(serialize=false)
    private Date dlfCreatetime;

    @ApiModelProperty(value = "文件数字签名认证")
    @TableField(exist = false)
    private DeviceLinkFileSign Sign;

}
