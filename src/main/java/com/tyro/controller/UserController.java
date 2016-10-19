package com.tyro.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyro.domain.User;
import com.tyro.service.UserService;

@RestController
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/greeting")
	public String hello() {
		return "hello world";
	}

	@RequestMapping("/user/list")
	public List<User> userList() {
		return userService.getUserList();
	}
}
