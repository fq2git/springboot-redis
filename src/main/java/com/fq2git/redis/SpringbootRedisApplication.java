package com.fq2git.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRedisApplication {

    public static void main(String[] args) {
        System.out.printf("hello redis!!");
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }

}

