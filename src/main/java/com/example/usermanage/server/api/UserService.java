package com.example.usermanage.server.api;

import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;

/**
 * TODO 微服务化，拆分出单独的服务
 * Author wangjinshuai
 * Date 2022/9/1 22:19
 **/
public interface UserService {

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    User getUserById(long userId) throws Exception ;

    /**
     * 保存用户
     * @param
     * @return
     */
    long saveUser(UserDTO userDTO) throws Exception;
}
