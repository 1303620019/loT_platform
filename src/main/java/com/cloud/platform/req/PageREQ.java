package com.cloud.platform.req;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cloud.platform.base.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.req
 * @author:byl
 * @createTime:2022/1/7 19:41
 * @version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value="PageREQ对象", description = "分页信息")
public class PageREQ  {
  @JsonProperty("pageStr")
  @ApiModelProperty(value = "页码")
  public String pageStr;
  @JsonProperty("limitStr")
  @ApiModelProperty(value = "多少条")
  public String limitStr;
}
