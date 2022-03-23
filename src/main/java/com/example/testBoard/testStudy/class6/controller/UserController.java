package com.example.testBoard.testStudy.class6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.testBoard.testStudy.class6.domain.User;
import com.example.testBoard.testStudy.class6.service.UserService;

//@RestController
//@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * public List<User> getUserList() {
	 * 
	 * }
	 * 
	 * public User findUserByID() {
	 * 
	 * }
	 */

}
