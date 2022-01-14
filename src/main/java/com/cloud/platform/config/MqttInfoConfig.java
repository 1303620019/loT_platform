package com.cloud.platform.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description:
 * @projectName:loT_platform
 * @see:com.cloud.platform.config
 * @author:byl
 * @createTime:2022/1/7 17:35
 * @version:1.0
 */
@Data
@Configuration
@PropertySource("classpath:mqtt.properties")//注意路径
public class MqttInfoConfig {
  @Value("${host}")
  private String host;

  @Value("${port}")
  private int port;
  @Value("${port1}")
  private int port1;
  @Value("${clientId}")
  private String clientId;




  public int getPort1() {
    return port1;
  }

  public void setPort1(int port1) {
    this.port1 = port1;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }


  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }
}
