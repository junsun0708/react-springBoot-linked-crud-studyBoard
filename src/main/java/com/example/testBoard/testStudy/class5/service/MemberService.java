package com.example.testBoard.testStudy.class5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.testBoard.testStudy.class5.domain.Member;
import com.example.testBoard.testStudy.class5.repository.MemberRepository;

//@Service
//@Transactional
public class MemberService {

	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Long join(Member member) {
		// 같은 이름이 있는 중복회원X
		// 1
		/*
		 * Optional<Member> result = memberRepository.findByName(member.getName());
		 * result.ifPresent(m -> { throw new IllegalStateException("이미 존재하는 회원입니다.");
		 * });
		 */

		// 2
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	//2. optional을 get으로 바로 반환하는것보다 아래처럼 쓰는게 좋다.
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
