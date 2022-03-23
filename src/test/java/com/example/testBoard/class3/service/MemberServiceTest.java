package com.example.testBoard.class3.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.testBoard.testStudy.class3.domain.Member;
import com.example.testBoard.testStudy.class3.repository.MemoryMemberRepository;
import com.example.testBoard.testStudy.class3.service.MemberService;

public class MemberServiceTest {
	//MemberService memberService = new MemberService();
	//MemoryMemberRepository memberRepository = new MemoryMemberRepository(); //다른 인스턴스이기 때문에 메인과 테스트의 인스턴스를 맞출려면 before로 바꾸는게 좋음.
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository); //di
	}

	/*
	 * @AfterEach public void afterEach() { memberRepository.clearStore(); }
	 */

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

	@Test
	void findMembers() {
	}

	@Test
	void findOne() {
	}
}
