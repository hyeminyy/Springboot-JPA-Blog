package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//사용자가 요청 -> 응답(HTML 파일)
//@Controller 

//사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest"; 
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1, "ssar","1234","ssar@naver.com");
		Member m = Member.builder().username("ssar").password("1234").email("ssar@naver.com").build();
		System.out.println(TAG + "getter :" + m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG + "setter :" + m.getUsername());
		return "lombok test 완료";
		//생성자로 넣었을 땐 순서를 지켜야 함 ( 1, ssar , 1234, ssar@naver.com);
		//builder을 쓰면 순서를 안 지켜도 됨.
	}
	
	//인터넷 브라우저 요청은 무조건 get 요청 밖에 할 수 없다. (post, put, delete 요청은 안 됨)
	//http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) { //id=1&username=hm&password=1234&email=ssar@naver.com
		
		
		return "get 요청 : "+m.getId() + "," + m.getUsername()+ "," + m.getPassword() + ","+m.getEmail();
	}
	//http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //MessageConverter!
		return "post 요청 : "+m.getId() + "," + m.getUsername()+ "," + m.getPassword() + ","+m.getEmail();
	}
	//http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	//http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
