package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;


import com.cos.blog.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	@Autowired
	@Qualifier("encodePWD")
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //username, password, email
		System.out.println("UserApiController :save 호출됨");
		//실제로 DB에 insert를 하고 아래에서 return 이 되면 
		
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){ //key = value, x-www-form-urlencoded
		userService.회원수정(user);
		//여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음
		//하지만 세션 값은 변경되지 않은 상태이기 때문에 우리가 직접 세션 값을 변경해줄 것임.

		Authentication authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		
	}
	
}
