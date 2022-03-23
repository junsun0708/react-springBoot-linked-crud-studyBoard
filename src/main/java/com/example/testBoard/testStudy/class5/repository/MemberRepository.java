package com.example.testBoard.testStudy.class5.repository;

import java.util.List;
import java.util.Optional;

import com.example.testBoard.testStudy.class5.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
