package com.example.usermanage.service.impl;

import com.example.usermanage.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Author wangjinshuai
 * Date 2022/9/1 22:04
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
