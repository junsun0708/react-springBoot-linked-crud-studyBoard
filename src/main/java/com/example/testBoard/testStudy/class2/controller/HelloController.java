package com.example.testBoard.testStudy.class2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RestController
public class HelloController {

	@GetMapping("hello") ///http://localhost:8080/hello
	public String hello(Model model) {
		model.addAttribute("data", "hello class2!!!");
		return "hello";
	}

	@GetMapping("hello-mvc") //http://localhost:8080/hello-mvc?name=spring!!!
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-templete";
	}

	@GetMapping("hello-string") //http://localhost:8080/hello-string?name=kkk
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}

	@GetMapping("hello-api")//http://localhost:8080/hello-api?name=kkk
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}

	static class Hello {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
