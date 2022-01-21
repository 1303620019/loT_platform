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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class MqttDemoApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application =SpringApplication.run(MqttDemoApplication.class, args);
		Environment env = application.getEnvironment();
		String port = env.getProperty("server.port");
		String path = oConvertUtils.getString(env.getProperty("server.servlet.context-path"));
		InetAddress addr = InetAddress.getLocalHost();
		Date date = new Date();
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

		log.info("\n----------------------------------------------------------\n\t" +
						"Application Jeecg-Boot is running! Access URLs:\n\t" +
						"Local: \t\thttp://"+addr.getHostAddress()+":" + port + path + "/\n\t" +
						"启动时间: \t" + sdf.format(date) + "\n\t" +
						"Swagger文档: \thttp://"+addr.getHostAddress()+":" + port + path + "/doc.html\n" +
						"----------------------------------------------------------");
	}
}
class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder application) {
		return application.sources(MqttDemoApplication.class);
	}
}
