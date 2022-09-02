package com.example.usermanage.server.service.impl;

import com.example.usermanage.server.api.UserService;
import com.example.usermanage.server.service.entity.User;
import com.example.usermanage.server.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author wangjinshuai
 * Date 2022/9/1 22:22
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long userId) throws Exception {
        return userRepository.getUserById(userId);
    }
}
