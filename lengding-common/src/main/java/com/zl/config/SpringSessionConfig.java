package com.zl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//开启spring-session
@EnableRedisHttpSession
@Configuration
public class SpringSessionConfig {

}
