package com.cloud.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
				.globalOperationParameters(parameters()).apiInfo(apiInfo()).select()
				// 自行修改为自己的包路径
				.apis(RequestHandlerSelectors.basePackage("com.cloud.platform")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("智能配电后台管理系统").description("台区智能融合终端（以下简称“终端”）与云平台之间的交互协议（以下简称“平台”），包含平台对终端的设备管理、容器管理、应用管理等内容。\n")
				// 服务条款网址
				.termsOfServiceUrl("http://localhost:8991").version("1.0")
				.contact(new Contact("边亚龙", "", "1303620019@qq.com")).build();
	}

	private List<Parameter> parameters() {
		List<Parameter> para = new ArrayList<>();
		return para;
	}

}
