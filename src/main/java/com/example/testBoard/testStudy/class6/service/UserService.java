package com.example.testBoard.testStudy.class6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testBoard.testStudy.class6.domain.User;
import com.example.testBoard.testStudy.class6.repository.UserRepository;

//@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void create(User user) {
		userRepository.save(user);
	}
	
	public List<User> readAll() {
		return userRepository.findAll();
	}
	
	public User readById(User user) {
		return userRepository.findById(user.getUsid()).get();
	}
	
	public void update(User user) {
		User findUser = readById(user);
		//set
		userRepository.save(findUser);
	}
	
	public void delete(User user) {
		userRepository.save(user);
	}
}
