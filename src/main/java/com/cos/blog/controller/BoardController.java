package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.auth.PrincipalDetail;

@Controller
public class BoardController {
//	@Autowired
//	private PrincipalDetail principal;
	
	@GetMapping({"", "/"})
	public String index() {
		//WEB-INF/views/index.jsp
		return "index";
	}
	
	//user 권한이 필
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
}
