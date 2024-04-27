package com.shiyu.cloud.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.shiyu.cloud" })
public class ShiyuProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuProductApplication.class, args);
    }

}
