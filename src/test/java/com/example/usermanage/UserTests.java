package com.example.usermanage;

import com.example.usermanage.server.api.UserService;
import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        User user = userService.getUserById(1L);
        Assert.assertTrue(user == null);
    }

    @Test
    public void testSaveUser() throws Exception {
        UserDTO userDTO = UserDTO.UserDTOBuilder.anUserDTO()
                .withName("zhang123")
                .withEmail("zhang@126.com")
                .build();

        long userId = userService.saveUser(userDTO);

        Assert.assertTrue(userId > 0);
    }

}
