package com.cloud.platform.req;

import com.cloud.platform.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="AuthenticationREQ对象", description = "认证信息")
public class AuthenticationREQ extends BaseRequest {

    @ApiModelProperty(value = "状态(1：订阅 ,2：发布)")
    private Integer access;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "客户端id")
    private String clientid;

    @ApiModelProperty(value = "ip地址")
    private String ipaddr;

    @ApiModelProperty(value = "主题")
    private String topic;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "挂载点")
    private String mountpoint;
}