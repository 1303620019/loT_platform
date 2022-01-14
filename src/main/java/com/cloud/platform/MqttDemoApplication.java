package com.cloud.platform;

import com.baomidou.mybatisplus.annotation.IdType;
import com.cloud.platform.util.oConvertUtils;

import javafx.application.Application;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class MqttDemoApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application =SpringApplication.run(MqttDemoApplication.class, args);
		Environment env = application.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("server.port");
		String path = oConvertUtils.getString(env.getProperty("server.servlet.context-path"));
		log.info("\n----------------------------------------------------------\n\t" +
						"Application Jeecg-Boot is running! Access URLs:\n\t" +
						"Local: \t\thttp://localhost:" + port + path + "/\n\t" +
						"External: \thttp://localhost:" + port + path + "/\n\t" +
						"启动时间: \t" + new Date() + "\n\t" +
						"Swagger文档: \thttp://localhost:" + port + path + "/doc.html\n" +
						"----------------------------------------------------------");
	}
}
class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder application) {
		return application.sources(MqttDemoApplication.class);
	}
}
