package com.calikus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleRedisCachePostgreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRedisCachePostgreApplication.class, args);
    }

}
