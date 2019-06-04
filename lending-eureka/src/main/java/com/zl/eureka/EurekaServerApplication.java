package com.zl.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 该注解说明,这是个服务器,类似于多人聊天系统中的服务器,远程访问时,服务器提供找目标方法的任务(当然可以带参数)
 * 启动端口时,先启动服务器,再启动客户端
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
