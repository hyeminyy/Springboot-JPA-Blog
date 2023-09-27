package com.cos.blog.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cos.blog.model.User;

// 스프링 시큐리티가 로그 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
//스프링 시큐리티의 고유한 세션 저장소에 저장을 해줌.
public class PrincipalDetail implements UserDetails{
	private User user; //컴포지션 


	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 리턴한다. (true = 만료 안됨) 
	@Override
	public boolean isAccountNonExpired() {
		return true; //false 가 되면 로그인 안 됨 
	}
	//계정이 만료되지 않았는지 리턴한다. (true = 만료 안됨) 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	//비밀번호가 만료되지 않았는지 리턴한다. (true = 만료 안됨) 
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	// 계정이 활성화(사용 가능)인지 리턴한다. 
	@Override
	public boolean isEnabled() {
		return true;
	}
	//계정이 어떤 권한을 가졌는지 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "ROLE_"+user.getRole(); //ROLE_USER 
			}
		});
		
		return collectors;
	}
}
