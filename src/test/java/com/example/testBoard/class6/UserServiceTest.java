package com.example.testBoard.class6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testBoard.testStudy.class6.domain.User;
import com.example.testBoard.testStudy.class6.repository.UserRepository;

@SpringBootTest
@Transactional
public class UserServiceTest {
	@Autowired
	UserRepository userRepository;

	@Test
	void 사용자추가() {
		User user = new User();
		user.setUsid("testUser01");
		user.setName("테스트유저01");
		user.setDept("1");
		user.setTeam("1");
		user.setLocked("N");
		user.setPwfailcnt(0);

		//User saveUser = userRepository.save(user);
		//assertThat(user.getName()).isEqualTo(saveUser.getName());
		userRepository.save(user);
	}

	@Test
	void 사용자조회() {
		User user = new User();
		user.setUsid("admin");
		user.setName("어드민");

		Optional<User> findUser = userRepository.findById(user.getUsid());
		//System.out.println(findUser.toString());
		assertThat(user.getName()).isEqualTo(findUser.get().getName());

		List<User> userList = userRepository.findAll();
		userList.stream().forEach(s -> System.out.println(s));
		
		
	}

	@Test
	void 사용자수정() {
		User user = new User();
		user.setUsid("testUser01");

		User findUser = userRepository.findById(user.getUsid()).get();

		findUser.setName("테스트유저05");
		findUser.setDept("4");
		findUser.setTeam("5");
		findUser.setPhone_number("0123234324");

		//User saveUser = userRepository.save(findUser);
		//assertThat(findUser.getName()).isEqualTo(saveUser.getName());
		userRepository.save(findUser);
	}

	@Test
	void 사용자삭제() {
		User user = new User();
		user.setUsid("testUser01");

		User findUser = userRepository.findById(user.getUsid()).get();
		//userRepository.delete(findUser);
	}
	
}
