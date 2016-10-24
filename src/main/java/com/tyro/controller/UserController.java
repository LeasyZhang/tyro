package com.tyro.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tyro.domain.User;
import com.tyro.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<User> userList() {
		return userService.getUserList();
	}

	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
	public String ping(){
		return "pong";
	}
}
