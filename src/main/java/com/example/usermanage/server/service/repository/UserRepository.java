package com.example.usermanage.server.service.repository;

import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;
import com.example.usermanage.server.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author wangjinshuai
 * Date 2022/9/2 16:14
 **/
@Component
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    public List<User> getUserByDTO(UserDTO userDTO) {
        return userMapper.getUserByDTO(userDTO);
    }

    public Long saveUser(User user) {
        return userMapper.saveUser(user);
    }

    public Integer updateUser(UserDTO userDTO) {
        return userMapper.updateUser(userDTO);
    }
}
