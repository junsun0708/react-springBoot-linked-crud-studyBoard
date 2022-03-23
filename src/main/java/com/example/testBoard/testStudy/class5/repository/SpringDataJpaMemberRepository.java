package com.example.testBoard.testStudy.class5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testBoard.testStudy.class5.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

	@Override
	Optional<Member> findByName(String name);
}
