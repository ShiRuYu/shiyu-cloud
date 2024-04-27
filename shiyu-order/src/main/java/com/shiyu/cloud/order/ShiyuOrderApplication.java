package com.shiyu.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = { "com.shiyu.cloud" })
public class ShiyuOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuOrderApplication.class, args);
    }

}
