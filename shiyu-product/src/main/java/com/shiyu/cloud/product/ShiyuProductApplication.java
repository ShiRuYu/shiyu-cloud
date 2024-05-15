package com.shiyu.cloud.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.shiyu.cloud"})
@EnableFeignClients(basePackages = {"com.shiyu.cloud.feign.**"})
public class ShiyuProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuProductApplication.class, args);
    }

}
