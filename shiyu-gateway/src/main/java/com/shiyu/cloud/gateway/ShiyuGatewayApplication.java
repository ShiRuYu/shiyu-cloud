package com.shiyu.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.shiyu.cloud" })
public class ShiyuGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuGatewayApplication.class, args);
    }

}
