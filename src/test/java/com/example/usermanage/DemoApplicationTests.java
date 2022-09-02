package com.example.usermanage;

import com.example.usermanage.server.api.UserService;
import com.example.usermanage.server.service.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

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
}
