package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일 리턴 기본 경로: src/main/resources/static 에 home.html 파일을 리턴
		// 리턴명: home.html
		// 풀 경로: src/main/resources/static/home.html
		return "home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tempjsp(){
		//prefix : WEB-INF/views
		//suffix : jsp
		//full name : /WEB-INF/views/test.jsp
		return "test";
	}
}

