package com.cloud.platform.config;

import com.cloud.platform.tools.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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
    registry.addViewController("/login").setViewName("login");
   }
  /**
   * 允许跨域
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
            .allowCredentials(true).maxAge(3600);
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
                    "/doc.html",
                    "/client/**"
            );
  }
}
