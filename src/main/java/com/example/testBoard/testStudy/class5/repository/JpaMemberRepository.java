package com.example.testBoard.testStudy.class5.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.example.testBoard.testStudy.class5.domain.Member;

public class JpaMemberRepository implements MemberRepository {

	private EntityManager em;// 이게 데이터소스 커넥션등 다 들고있음

	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name).getResultList();
		return result.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
}
