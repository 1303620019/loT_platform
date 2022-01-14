package com.cloud.platform.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.cloud.platform.base.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.req
 * @author:byl
 * @createTime:2022/1/10 17:49
 * @version:1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DeviceREQ对象", description = "设备管理查询条件")
@JSONType(orders={"mid","deviceId","timestamp","type","param"})
public class MessageHeadREQ{
  @JSONField(ordinal = 1)
  @JsonProperty("mid")
  public Integer mid;
  @JsonProperty("expire")
  public Integer expire;
  @JSONField(ordinal = 2)
  @JsonProperty("deviceId")
  public String deviceId;
  @JSONField(ordinal = 4)
  @JsonProperty("type")
  public String type;
  @JSONField(ordinal = 3)
  @JsonProperty("timestamp")
  public String timestamp;
  @JSONField(ordinal = 5)
  @JsonProperty("param")
  public Object param;
  // 200-请求成功 202-请求被接受，但是服务器将要处理或未处理完
  //400-请求失败  401-请求未认证/认证错误   403-请求被拒绝
  //404 -请求的资源不存在 600- 其他错误
  @JSONField(ordinal = 6)
  @JsonProperty("code")
  public Integer code;
  @JSONField(ordinal = 7)
  @JsonProperty("msg")
  public String msg;
}


