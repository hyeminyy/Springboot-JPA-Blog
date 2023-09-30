package com.cos.blog.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
//인증이 안 된 사용자들이 출입할 수 있는 경로를 /auth/** 
//그냥 주소가 /이면 index.jsp 허용
//static 이하에 있는 /js/**, /css/**, /image/** 
@Controller
public class UserController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) { //데이터를 리턴해주는 컨트롤러 함수

	    // POST방식으로 key=value 데이터를 요청 (카카오쪽으로)
	    RestTemplate rt = new RestTemplate();  // http요청을 쉽게 할 수 있는 라이브러리

	    // HttpHeaders 오브젝트 생성
	    HttpHeaders headers = new HttpHeaders();
	    
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//HttpBody 오브젝트 생
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "e8649741f7412b4692346b5bc5ae9280");
		params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
		params.add("code", code);
		// HttpHeaders 와 HttpBody 를 하나의 오브젝트에 담기
	    HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
	            new HttpEntity<>(params, headers); //바디 데이터와 와 헤더값을 가지는 entity가 된다

	    // Http 요청하기 - POST방식으로 그리고 response 변수의 응답 받음
	    ResponseEntity<String> response = rt.exchange(
	    	     "https://kauth.kakao.com/oauth/token",   //토큰 발급 요청 주소
	    	     HttpMethod.POST,       //요청 메서드 post
	    	     kakaoTokenRequest,   // http헤더값 + http바디값
	    	     String.class                  // 응답받을 타입
	    	);

	    return response.getBody();
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
}
