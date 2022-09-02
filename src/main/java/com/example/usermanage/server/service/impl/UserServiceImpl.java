package com.example.usermanage.server.service.impl;

import com.example.usermanage.server.api.UserService;
import com.example.usermanage.server.service.convert.UserConvert;
import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;
import com.example.usermanage.server.service.exception.BizException;
import com.example.usermanage.server.service.repository.UserRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Author wangjinshuai
 * Date 2022/9/1 22:22
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserByDTO(UserDTO userDTO) throws Exception {
        return userRepository.getUserByDTO(userDTO);
    }

    @Override
    public long saveUser(UserDTO userDTO) throws Exception {

        Preconditions.checkNotNull(userDTO, "用户信息不能为空");
        Preconditions.checkNotNull(userDTO.getName(), "用户名称不能为空");
        Preconditions.checkNotNull(userDTO.getEmail(), "邮箱不能为空");

        // 构建用户判重条件
        UserDTO queryDTO = UserDTO.UserDTOBuilder.anUserDTO()
                                    .withEmail(userDTO.getEmail())
                                    .build();
        List<User> userList = userRepository.getUserByDTO(queryDTO);

        if (!CollectionUtils.isEmpty(userList)) {
            throw new BizException("用户已存在");
        }

        // 写用户信息
        long userId = userRepository.saveUser(UserConvert.toUser.apply(userDTO));

        // TODO mq 发送邮件，回写发送状态

        return userId;
    }

    public Integer updateUser(UserDTO userDTO) {

        Preconditions.checkNotNull(userDTO, "用户信息不能为空");
        Preconditions.checkNotNull(userDTO.getId(), "用户标示不能为空");

        return userRepository.updateUser(userDTO);
    }
}
