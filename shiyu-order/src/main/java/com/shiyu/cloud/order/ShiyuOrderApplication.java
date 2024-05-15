package com.shiyu.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"com.shiyu.cloud"})
@EnableFeignClients(basePackages = {"com.shiyu.cloud.feign.**"})
public class ShiyuOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuOrderApplication.class, args);
    }

}
