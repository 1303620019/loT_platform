package com.cloud.platform.config;

import com.cloud.platform.tools.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.config
 * @author:byl
 * @createTime:2022/1/6 16:31
 * @version:1.0
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

  @Autowired
  private LoginInterceptor loginInterceptor;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");;
  }
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    //直接访问页面配置
    registry.addViewController("/").setViewName("login");
   }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
            .excludePathPatterns("/login",
                    "/static/css/**",
                    "/static/images/**",
                    "/static/js/**",
                    "/static/fonts/**",
                    "/static/webfonts/**",
                    "/loginSign",
                    "/mqtt/**",
                    "/event/**",
                    "/client/**"
            );
  }
}
