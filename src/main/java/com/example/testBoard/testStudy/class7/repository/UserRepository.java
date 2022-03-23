package com.example.testBoard.testStudy.class7.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testBoard.testStudy.class7.domain.User;

//컴파일 에러가 나서 실행이 안되므로 일단 막고 아래의 임의의 메서드를 만들어둠. class7는 주석부분것을 사용해야 함.
//@Repository
//public interface UserRepository extends JpaRepository<User, String>{}
public interface UserRepository{

	void save(User user);

	List<User> findAll();

	Optional<User> findById(String usid);
	
}
	