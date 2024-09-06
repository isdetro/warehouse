package com.finalproject.warehousemanagementsystem.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Value("${spring.data.redis.host}")
    private String host;
    @Value("${spring.data.redis.port}")
    private Integer port;


    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
        return new LettuceConnectionFactory(configuration);
    }

//    @Bean(name = {"loanInsuranceRedisTemplate"})
//    public RedisTemplate<String, Object> redisTemplateCommon() {
//        final RedisTemplate<String, Object> template = new RedisTemplate<>;
//        template.setConnectionFactory(redisConnectionFactory));
//        var stringRedisSerializer = new StringRedisSerializer;
//        var jacksonRedisSerializer = new GenericJackson2JsonRedisSerializer();
//        template.setKeySerializer(stringRedisSerializer);
//        template.setValueSerializer(jacksonRedisSerializer);
//        template.setHashKeySerializer(stringRedisSerializer);
//        template.setHashValueSerializer(jacksonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
}
