package com.zl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 扫描跨端口访问规则,也就是commom模块中的com.zl.client包下的所有接口,
 * 例如可以扫描com.zl.client.LoginServiceClient类
 */
@EnableFeignClients(basePackages = {"com.zl.client"})
/**
 * 该注解说明,这是个客户端,类似于多人聊天系统中的客户端
 *提供同一种服务的客户端可以有很多,相当于一个tomcat集群提供同一种服务,
 *服务器会自动找其中某一个客户端提供服务,只有当该服务的所有客户端全部
 *宕机,才会无法提供该服务,因此容灾性大大提高
 */
@EnableEurekaClient

/**
 * 启动方式1
 */
//@SpringBootApplication

/**
 * 启动方式2
 * 第一步:扫描所有的注解
 */
@ComponentScan(basePackages = "com.zl.controller,com.zl.service.impl,com.zl.component,com.zl.config") 
/**
*启动方式2
 * 第二步:开启自动配置注解
 * 禁用springsecurity的默认用户名和密码
 */
@EnableAutoConfiguration(exclude = { 
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class 
})

/**
 * @ImportResource注解可以加载配置文件,包括spring的配置文件,sql语句的xml文件等等所有的配置文件
 * 以下例子中两个扫描的路径不同,
 * classpath:mapper/*Mapper.xml在resources目录下,
 * classpath*:/dao/*.xml在com/zl/dao目录下,
 * 扫描com.zl.dao包下所有的.xml文件 @ImportResource(locations = {"classpath:mapper/*Mapper.xml"})
 */
//@ImportResource(locations = {"classpath:mapper/*Mapper.xml"})
@ImportResource(locations = {"classpath*:/dao/*.xml"}) 

/**一次性扫描com.zl.dao包下的所有Mapper接口*/
@MapperScan("com.zl.dao")
public class TenderServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TenderServerApplication.class, args);
	}
}
