package com.example.testBoard.class5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testBoard.testStudy.class5.domain.Member;
import com.example.testBoard.testStudy.class5.repository.MemoryMemberRepository;
import com.example.testBoard.testStudy.class5.service.MemberService;

@SpringBootTest
@Transactional
public class MemberServiceIntTest {
	@Autowired MemberService memberService;
	@Autowired MemoryMemberRepository memberRepository;
	
	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("hello");

		// when
		Long svaeId = memberService.join(member);

		// then
		Member findeMember = memberService.findOne(svaeId).get();
		// Optional<findeMember> = memberService.findOne(svaeId);
		assertThat(member.getName()).isEqualTo(findeMember.getName());
	}

	@Test
	public void 중복_회원_예외() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");

		Member member2 = new Member();
		member2.setName("spring1");

		// when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		/*
		 * memberService.join(member1); try { memberService.join(member2); fail(); }
		 * catch (IllegalStateException e) {
		 * assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); }
		 */

		// then
	}
}
