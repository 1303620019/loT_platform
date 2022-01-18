package com.cloud.platform.base;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.base
 * @author:byl
 * @createTime:2022/1/14 23:37
 * @version:1.0
 */

import com.cloud.platform.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于封装接口统一响应结果
 */
@Data
@NoArgsConstructor // 无参构造方法
@AllArgsConstructor // 有参构造方法

public class ResultVo {
  private static final Logger logger = LoggerFactory.getLogger(Result.class);

  private static final long serialVersionUID = 1L;
  /**
   * 响应业务状态码
   */
  private Integer code;
  /**
   * 响应中的数据
   */
  private Object data;
  /**
   * 响应总记录数
   */
  private long count;

  /**
   * 响应信息
   */
  private String message;

  public static ResultVo ok(Object data,long count) {
    return new ResultVo(0, data,count,"请求成功");
  }

  public static ResultVo error(String message) {
    return new ResultVo(ResultEnum.ERROR.getCode(), null,0,message);
  }
}
