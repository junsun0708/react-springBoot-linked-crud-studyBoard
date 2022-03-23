package com.example.testBoard.testStudy.class7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testBoard.testStudy.class7.domain.User;
import com.example.testBoard.testStudy.class7.service.UserService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

//@RestController
//@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("readData")
	//public List<User> getUserList() {
	public String getUserList() {
		System.out.println("유저 리스트 출력");
		List<User> userList = userService.readAll();
		
		JsonArray ja = new JsonArray();
		for(int i=0; i<userList.size(); i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("usid", userList.get(i).getUsid());
			jObj.addProperty("name", userList.get(i).getName());
			jObj.addProperty("dept", userList.get(i).getDept());
			jObj.addProperty("team", userList.get(i).getTeam());
			jObj.addProperty("duty_c", userList.get(i).getDuty_c());
			jObj.addProperty("email", userList.get(i).getEmail());
			jObj.addProperty("phone_number", userList.get(i).getPhone_number());
			ja.add(jObj);
		}
		
		JsonObject jo2 = new JsonObject();
		jo2.addProperty("page", 1);
		jo2.addProperty("totalCount", 100);
		
		JsonObject jo1 = new JsonObject();
		jo1.add("contents", ja);
		jo1.add("pagination", jo2);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("result", true);
		jo.add("data", jo1);
		
		return jo.toString();
		//return userService.readAll();
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
