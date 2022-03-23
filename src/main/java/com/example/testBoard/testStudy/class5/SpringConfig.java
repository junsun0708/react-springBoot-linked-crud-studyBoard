package com.example.testBoard.testStudy.class5;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testBoard.testStudy.class5.aop.TimeTraceAop;
import com.example.testBoard.testStudy.class5.repository.JpaMemberRepository;
import com.example.testBoard.testStudy.class5.repository.MemberRepository;
import com.example.testBoard.testStudy.class5.service.MemberService;

//@Configuration
public class SpringConfig {

	/*	//jdbc, jdbctemplate
	 * private DataSource datasource;
	
	 *
	 * @Autowired public SpringConfig(DataSource datasource) { this.datasource =
	 * datasource; }
	 */
	
	/*// jpa
	 * private EntityManager em;
	 * 
	 * @Autowired public SpringConfig(EntityManager em) { this.em = em; }
	 */
	

	/*	
	@Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
    	//return new JdbcMemberRepository(datasource);
    	//return new JdbcTemplateMemberRepository(datasource);
    	//return new JpaMemberRepository(em);
    }
*/    
	private final MemberRepository memberRepository;

	//@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

}
