package com.example.testBoard.testStudy.class5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.testBoard.testStudy.class5.domain.Member;
import com.example.testBoard.testStudy.class5.service.MemberService;

//@Controller
public class MemberController {
	private final MemberService memberService;
	// @Autowired private MemberService memberService; //DI - 필드주입(중간에 바꿀 빙법이 없음)

	/*
	 * @Autowired public void setMemberService(MemberService memberService) {
	 * this.memberService = memberService; } //DI - setter주입 (누군가가 memberController을
	 * 호출할때 puplic으로 되어있어야함. 따라서 변경위험성 있음)
	 */
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	} // DI- 생성자주입 (결론적으로 이걸 쓰는게 좋음. 의존관계가 실행중에 동적으로 변하는 경우는 거의없다)

	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";// templates에 html호출
	}

	@PostMapping("/members/new")
	public String create(MemberForm form) { // 화면에서 버튼을 누르면 name값을 받아와 메서드 실행
		Member member = new Member();
		member.setName(form.getName());

		memberService.join(member);

		return "redirect:/"; // 원래화면으로 돌아감
	}

	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}
