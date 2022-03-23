package com.example.testBoard.testStudy.class8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testBoard.testStudy.class8.domain.User;
import com.example.testBoard.testStudy.class8.service.UserService;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	private String createdRows;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("readData")
	public List<User> getUserList() {
	//public String getUserList() {
		System.out.println("유저 리스트 출력");
		/*List<User> userList = userService.readAll();
		
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
		
		return jo.toString();*/
		return userService.readAll();
	}
	
	@PostMapping("createData")
	//public List<User> getUserList() {
	public String addUser(@RequestBody User user) {
		System.out.println(user);
		System.out.println("유저 추가");
		//userService.create(user);
		
		//class8
		/*JsonArray ja = new JsonArray();
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
		}*/
		
		/*JsonObject jo2 = new JsonObject();
		jo2.addProperty("page", 1);
		jo2.addProperty("totalCount", 100);
		
		JsonObject jo1 = new JsonObject();
		jo1.add("contents", ja);
		jo1.add("pagination", jo2);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("result", true);
		jo.add("data", jo1);
		
		return jo.toString();*/
		//return userService.readAll();
		
		//class8-1
		userService.create(createData(user));
		return returnMsg();
	}
	
	@PutMapping("updateData")
	public String updateUser(@RequestBody User user) {
		userService.update(createData(user));
		return returnMsg();
	}
	
	@DeleteMapping("deleteData")
	public String deleteUser(@RequestBody User user) {
		userService.delete(user);
		return returnMsg();
	}
	
	public User createData(User user) {
		user.setDuty_c("");
		user.setGl_cd("");
		user.setLocked("N");
		user.setOtp_use_yn("");
		user.setOutAdminCode("");
		user.setPhone_number("");
		user.setPos_c("");
		user.setProxy_end_dt(null);
		user.setProxy_start_dt(null);
		user.setPwfailcnt(0);
		user.setRank_c("");
		user.setRole_type("");
		user.setUnused("");
		user.setUser_ip("");
		user.setUser_type("");
		user.setUsid_exp_dt(null);
		user.setUspw("");
		user.setUspw_chng_dt(null);
		
		return user;
	}
	
	public String returnMsg() {
		JsonObject jo = new JsonObject();
		jo.addProperty("message", "success");
		jo.addProperty("status", "ok");
		
		return jo.toString();
	}

}
