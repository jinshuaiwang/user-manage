package com.example.usermanage.server.service.repository;

import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;
import com.example.usermanage.server.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author wangjinshuai
 * Date 2022/9/2 16:14
 **/
@Component
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(long userId) {
        return userMapper.getUserById(userId);
    }

    public User getUserByDTO(UserDTO userDTO) {
        return userMapper.getUserByDTO(userDTO);
    }

    public Long saveUser(User user) {
        return userMapper.saveUser(user);
    }
}
