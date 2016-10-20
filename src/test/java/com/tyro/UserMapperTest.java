package com.tyro;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyro.domain.User;
import com.tyro.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelectList() {
		List<User> users = userMapper.selectUserList();
		assertEquals(3, users.size());
	}
}
