package com.shiyu.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.shiyu.cloud" })
public class ShiyuUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuUserApplication.class, args);
    }

}
