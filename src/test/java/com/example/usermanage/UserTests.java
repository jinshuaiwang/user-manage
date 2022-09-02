package com.example.usermanage;

import com.example.usermanage.server.api.UserService;
import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Author wangjinshuai
 * Date 2022/9/2 18:11
 **/
@SpringBootTest
public class UserTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void getUserById() throws Exception {
        UserDTO userDTO = UserDTO.UserDTOBuilder.anUserDTO()
                                        .withId(1L)
                                        .build();

        List<User> userList = userService.getUserByDTO(userDTO);
        Assert.assertTrue(!CollectionUtils.isEmpty(userList));


        userDTO = UserDTO.UserDTOBuilder.anUserDTO()
                .withName("zhangsan")
                .build();

        userList = userService.getUserByDTO(userDTO);
        Assert.assertTrue(!CollectionUtils.isEmpty(userList));

        userDTO = UserDTO.UserDTOBuilder.anUserDTO()
                .withName("zhang123")
                .build();

        userList = userService.getUserByDTO(userDTO);
        Assert.assertTrue(!CollectionUtils.isEmpty(userList));
    }

    @Test
    public void testSaveUser() throws Exception {
        UserDTO userDTO = UserDTO.UserDTOBuilder.anUserDTO()
                .withName("zhang1234")
                .withEmail("zhang2@126.com")
                .build();

        long userId = userService.saveUser(userDTO);

        Assert.assertTrue(userId > 0);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserDTO userDTO = UserDTO.UserDTOBuilder.anUserDTO()
                .withId(4L)
                .withName("zhang4")
                .withEmail("zhang1@126.com")
                .build();

        Integer count = userService.updateUser(userDTO);

        Assert.assertTrue(count > 0);
    }
}
