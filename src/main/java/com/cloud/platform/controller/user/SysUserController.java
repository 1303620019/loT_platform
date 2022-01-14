package com.cloud.platform.controller.user;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author byl
 * @since 2022-01-12
 */
@Slf4j
@Api(tags = "用户管理")
@RestController
@RequestMapping("sysUser")
public class SysUserController {

  @ApiOperation("修改用户密码")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "oldpwd", value = "旧密码", required = true, dataType = "String", paramType = "query"),
          @ApiImplicitParam(name = "newpwd", value = "新密码", required = true, dataType = "String", paramType = "query"),
          @ApiImplicitParam(name = "confirmpwd", value = "确认密码", required = true, dataType = "String", paramType = "query")
  })
  @PostMapping("/update/pwd")
  public void  upatePwd(String oldpwd,String newpwd,String confirmpwd){
     String val=oldpwd+newpwd+confirmpwd;
    log.info("参数列表{}",val);
  }



}
