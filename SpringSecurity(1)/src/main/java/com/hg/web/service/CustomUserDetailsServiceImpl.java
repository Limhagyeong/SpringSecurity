package com.hg.web.service;
// DB로부터 username에 대한 검증을 마치고 데이터를 저장하여 dto로 넘긴다
// dto에서는 전달받은 데이터를 가지고 시큐리티컨피그에서 넘기면 컨피그에서 검증하고 완료 후 스프링 세션에 데이터가 저장되게된다
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hg.web.dto.CustomUserDetails;
import com.hg.web.mapper.UserMapper;
import com.hg.web.vo.prouser;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService{
	private final UserMapper usermapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// DB로부터 username을 검증하여 데이터를 담음
		prouser data=usermapper.findID(username); 
		
		System.out.println("서비스 실행");
		System.out.println("서비스 데이터"+data);
		
		if (data == null) {
            // 예외를 던져서 사용자 정보를 찾지 못했음을 알림
            throw new UsernameNotFoundException("찾을 수 없는 사용자" + username);
        }
        
        // CustomUserDetails는 UserDetails 인터페이스를 구현한 클래스여야 함
        return new CustomUserDetails(data);
	}

}
