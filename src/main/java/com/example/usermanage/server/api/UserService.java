package com.example.usermanage.server.api;

import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;

import java.util.List;

/**
 * TODO 微服务化，拆分出单独的服务
 * Author wangjinshuai
 * Date 2022/9/1 22:19
 **/
public interface UserService {

    /**
     * 保存用户
     * @param
     * @return
     */
    long saveUser(UserDTO userDTO) throws Exception;

    /**
     * 更新
     * @param userDTO
     * @return
     */
    Integer updateUser(UserDTO userDTO) throws Exception;

    /**
     * 查询用户
     * @param userDTO
     * @return
     */
    List<User> getUserByDTO(UserDTO userDTO) throws Exception;
}
