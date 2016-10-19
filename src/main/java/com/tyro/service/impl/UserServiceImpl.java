package com.tyro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyro.domain.User;
import com.tyro.mapper.UserMapper;
import com.tyro.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getUserList() {
		return userMapper.selectUserList();
	}

}
