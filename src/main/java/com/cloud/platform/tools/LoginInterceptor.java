package com.cloud.platform.tools;


import com.cloud.platform.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private RedisUtils redisUtils;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		// 获得cookie
		Cookie[] cookies = request.getCookies();

		Object user = session.getAttribute("users");
		String tokenid = null;
		// 获取cookie里面的一些用户信息
		for (Cookie item : cookies) {
			if ("tokenid".equals(item.getName())) {
				tokenid = item.getValue();
				break;
			}
		}
		//通过redis获取用户
		if (user == null ) {
			user =redisUtils.get("lot_"+tokenid);
			if (!ObjectUtils.isEmpty(user)){
				session.setAttribute("users",user);
			}else{
				response.sendRedirect("/login");
				return false;
			}
		}
		return true;
	}
}
