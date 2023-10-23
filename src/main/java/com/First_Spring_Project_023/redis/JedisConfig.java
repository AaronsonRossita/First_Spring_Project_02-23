package com.First_Spring_Project_023.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class JedisConfig {

    @Autowired
    private RedisDetailsConfig redisDetailsConfig;

    @Bean
    public JedisPooled initJedisPooled(){
        System.out.println("Jedis was created with my config");
        return new JedisPooled(redisDetailsConfig.getHost(), redisDetailsConfig.getPort());
    }

}
