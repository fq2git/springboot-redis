package com.fq2git.redis.config;

import com.fq2git.redis.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    /**
     * 自定义序列化
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, UserEntity> UserEntityredisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, UserEntity> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        try{
            Jackson2JsonRedisSerializer<UserEntity> ser = new Jackson2JsonRedisSerializer<UserEntity>(UserEntity.class);
            template.setDefaultSerializer(ser);
        }catch (Exception e){
            e.printStackTrace();
        }

        return template;
    }
}
