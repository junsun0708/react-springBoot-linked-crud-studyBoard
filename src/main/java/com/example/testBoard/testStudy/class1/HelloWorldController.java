package com.example.testBoard.testStudy.class1;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

//@RestController // 통신할 때 응답값으로 JSON
public class HelloWorldController {
	@GetMapping("hello") // url hello
	public List<String> hello() {
		return Arrays.asList("안녕하세요", "Hello"); // 리턴값
	}
}
