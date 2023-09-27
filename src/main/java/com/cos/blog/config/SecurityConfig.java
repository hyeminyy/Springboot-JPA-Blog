package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.blog.auth.PrincipalDetailService;



@Configuration // 빈 등록 (IoC관리)
@EnableWebSecurity // Security 필터가 등록됨 = 스프링 시큐리티가 이미 활성화는 되어있지만, 설정은 해당 파일에서 할 것임
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크 (수행한 후에 체크하는 것이 아님)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 1. Bean 어노테이션은 메서드에 붙여서 객체 생성시 사용
    @Bean // IoC가 된다.
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder(); // 이 객체를 스프링이 관리하게 됨. 필요할 때마다 가져가서 쓰면 된다.
    }

    // 필터링
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
			.csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어두는게 좋음 )
			.authorizeRequests()
			.antMatchers("/","/auth/**", "/js/**", "/css/**", "/image/**","/dummy/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc")//스프링 시큐리티가 해당주소로 요청 오는 로그인을 가로 채서 대신 로그인 해줌. 
			.defaultSuccessUrl("/");
//                .failureUrl("/fail"); // 실패시 url
    }
}