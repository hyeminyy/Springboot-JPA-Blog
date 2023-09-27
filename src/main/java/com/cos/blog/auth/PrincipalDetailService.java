package com.cos.blog.auth;

import org.springframework.beans.factory.annotation.Autowired; // 추가
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository; // 수정: final 키워드 추가

//    @Autowired // 추가: UserRepository를 주입하기 위해 @Autowired 어노테이션 사용
//    public PrincipalDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
                });
        return new PrincipalDetail(principal);
    }
}
