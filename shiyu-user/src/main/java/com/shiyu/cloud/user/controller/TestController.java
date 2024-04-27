package com.shiyu.cloud.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("a")
public class TestController {

    @GetMapping("b")
    public String test() {
        return "1111";
    }
}
