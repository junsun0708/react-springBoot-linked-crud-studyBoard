package com.example.testBoard.testStudy.class2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller // 메인시작
public class HelloWorldController {
	@GetMapping("hello") // url hello
	public String hello(Model model) {
        model.addAttribute("data", "hello!!!MVC class2");
        return "hello";
	}
}
