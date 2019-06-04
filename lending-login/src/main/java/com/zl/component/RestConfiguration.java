package com.zl.component;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 组件类
 * 注入RestTemplate类,RestTemplate封装了httpClient,不同端口之间的(进程之间)访问时就得注入该类
 * 但实际上这种方式还不如使用feign优雅,feign其实也是封装了httpClient
 */
@Configuration
public class RestConfiguration {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule testRule() {
	    return new RandomRule();
	}
}