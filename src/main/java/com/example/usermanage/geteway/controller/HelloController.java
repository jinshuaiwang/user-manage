package com.example.usermanage.geteway.controller;

import com.example.usermanage.server.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: wangjinshuai
 * Time: 2022-05-11 5:52 PM
 * Email: jinshuaiwang@gmail.com
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return helloService.sayHello(name);
    }
}
