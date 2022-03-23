package com.example.testBoard.testStudy.class8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testBoard.testStudy.class8.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
	