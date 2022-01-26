package com.cloud.platform.controller.user;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.cloud.platform.comm.Result;
import com.cloud.platform.entity.user.SysUser;
import com.cloud.platform.service.user.ISysUserService;
import com.cloud.platform.util.Md5Util;
import com.cloud.platform.util.RedisUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.controller
 * @author:byl
 * @createTime:2022/1/11 18:27
 * @version:1.0
 */
@Slf4j
@Api(tags = "用户登录")
@Controller
public class LoginController {
  @Autowired
  private ISysUserService userService;
  @Autowired
  private RedisUtils redisUtils;
  @GetMapping("/login")
  public String index(){
    return "login";
  }

  @PostMapping("/loginSign")
  @ResponseBody
  public Result loginSign(HttpServletRequest request, HttpSession session,
                          HttpServletResponse response)throws Exception {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
    String passwordMd5 = Md5Util.StringInMd5(password);
    SysUser user = userService.getUser(username, passwordMd5);
    if (ObjectUtils.isEmpty(user)){
      return Result.error("此用户不存在,请输入正确的账号密码！");
    }
    session.setAttribute("users", user);
    // 保存cookie，实现自动登录
    Cookie cookie_tokenid = new Cookie("tokenid", token);
    //存在redis中记录登陆状态  6小时
    redisUtils.set("lot_"+token,user,6 * 60 * 60);
    // 设置cookie的持久化时间，12小时
    cookie_tokenid.setMaxAge(6 * 60 * 60);
    // 设置为当前项目下都携带这个cookie
    cookie_tokenid.setPath(request.getContextPath());
    // 向客户端发送cookie
    response.addCookie(cookie_tokenid);
    return Result.ok();
  }

  @GetMapping("/loginOut")
  public String  loginOut(HttpSession session,HttpServletRequest request,HttpServletResponse response){
    session.setAttribute("users",null);
    session.invalidate();
    // 保存cookie，实现自动登录
    Cookie cookie_tokenid = new Cookie("tokenid", "");
    // 设置cookie的持久化时间，0
    cookie_tokenid.setMaxAge(0);
    // 设置为当前项目下都携带这个cookie
    cookie_tokenid.setPath(request.getContextPath());
    // 向客户端发送cookie
    response.addCookie(cookie_tokenid);
    return "redirect:/login";
  }

}
