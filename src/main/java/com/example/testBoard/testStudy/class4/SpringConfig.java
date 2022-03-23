package com.example.testBoard.testStudy.class4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testBoard.testStudy.class4.repository.MemberRepository;
import com.example.testBoard.testStudy.class4.repository.MemoryMemberRepository;
import com.example.testBoard.testStudy.class4.service.MemberService;

//@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
