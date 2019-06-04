package com.zl.config;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
 
import java.util.List;
 
@Configuration
public class RedisConfig {
    // Redis 主机列表
    @Value("#{'${spring.redis.cluster.nodes}'.split(', ')}")
    private List<String> redisHosts;
    
    // Redis 密码
    @Value("${spring.redis.password}")
    private String redisPass;
    
    /*
        Redis 连接工厂
     */
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisClusterConfiguration configuration = new RedisClusterConfiguration(redisHosts);  // Redis 集群配置
        configuration.setPassword(RedisPassword.of(redisPass));  // 设置密码
        return new LettuceConnectionFactory(configuration);
    }
    
    /*
        RedisTemplate
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(factory);  // 设置 Redis 连接工厂
        return template;
    }
}
