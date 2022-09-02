package com.example.usermanage.geteway.controller;

import com.example.usermanage.geteway.convert.UserWebConvert;
import com.example.usermanage.geteway.eunms.WebResultCodeEnum;
import com.example.usermanage.geteway.param.WebResult;
import com.example.usermanage.geteway.param.user.UserRequest;
import com.example.usermanage.server.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** gateway server单独部署，微服务化
 * 网关 后端服务独立部署，网关内部需要做参数校验
 * Author wangjinshuai
 * Date 2022/9/2 21:50
 **/
@RequestMapping("/user")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

//    @GetMapping("/hello")
//    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return helloService.sayHello(name);
//    }

    @PostMapping("/register")
    public WebResult registerUser(UserRequest request) {
        try {
            // TODO param validate
            userService.saveUser(UserWebConvert.toUserDTO.apply(request));

            return WebResult.success();
        } catch (Exception e) {
            logger.error("registerUser error request:{}", request, e);
            return WebResult.fail(WebResultCodeEnum.SERVER_INNER_ERROR.getCode(), WebResultCodeEnum.SERVER_INNER_ERROR.getDesc());
        }
    }
}
