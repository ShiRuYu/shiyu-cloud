package com.shiyu.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.shiyu.cloud"})
@EnableFeignClients(basePackages = {"com.shiyu.cloud.feign.**"})
public class ShiyuUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuUserApplication.class, args);
    }

}
