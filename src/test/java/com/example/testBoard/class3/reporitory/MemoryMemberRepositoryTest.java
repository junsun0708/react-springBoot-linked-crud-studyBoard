package com.example.testBoard.class3.reporitory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.testBoard.testStudy.class3.domain.Member;
import com.example.testBoard.testStudy.class3.repository.MemoryMemberRepository;

public class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("Spring");
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		// System.out.println("" + (result == member));
		// Assertions.assertThat(member).isEqualTo(result);
		// Assertions.assertEquals(member, result);
		assertThat(member).isEqualTo(result);
	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member result = repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		List<Member> result = repository.findAll();
		assertThat(result.size()).isEqualTo(2); //이전 test에 repo에 저장해서 안맞게 결과가 나옴 -> clearStore 를 해줘야 동작
	}
}
