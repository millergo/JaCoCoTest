package com.github.miller.shan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: jacocotest
 * @Author: Miller
 * @Time: 2021-07-19 14:33
 * @Email: miller.shan@aliyun.com
 * @Description:
 **/
@RestController
public class CucumberController {
    @PostMapping("/helloCucumber")
    public String sayHello() {
        return "cucumber";
    }

    @GetMapping("/cucumber")
    public String sayHelloPost() {
        return "cucumber";
    }
}
