package com.cloud.platform.comm;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.base
 * @author:byl
 * @createTime:2022/1/14 23:37
 * @version:1.0
 */

import com.cloud.platform.enums.ResultEnum;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于封装接口统一响应结果
 */
@Data
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

  public ResultVo(){}
  public ResultVo(Integer code,Object data,long count){
    this.code=code;
    this.data=data;
    this.count=count;
  }
  public ResultVo(Integer code,Object data,String message){
    this.code=code;
    this.data=data;
    this.message=message;
  }
  public ResultVo(Integer code,Object data,long count,String message){
    this.code=code;
    this.data=data;
    this.count=count;
    this.message=message;
  }
  public static ResultVo ok(Object data,long count) {
    return new ResultVo(0, data,count,"请求成功");
  }
  public static ResultVo ok(Object data) {
    return new ResultVo(0, data,"请求成功");
  }
  public static ResultVo error(String message) {
    return new ResultVo(ResultEnum.ERROR.getCode(), null,0,message);
  }
}
