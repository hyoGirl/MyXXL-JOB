package com.xxl.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/6/23 21:16
 * @Version 1.0
 */
@SpringBootApplication
public class JobAPP01 {

    public static void main(String[] args) {

        SpringApplication.run(JobAPP01.class,args);

    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
