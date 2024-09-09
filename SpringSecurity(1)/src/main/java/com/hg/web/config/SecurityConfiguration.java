package com.hg.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public BCryptPasswordEncoder bcPwd() {
		return new BCryptPasswordEncoder(); // 암호화 진행 메소드
	}
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		
		http 
				.authorizeHttpRequests((auth)->auth
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/","/login","/loginproc","/join","/joinProc").permitAll() // 지정 경로에 대해 모든 접근을 허용함
				.requestMatchers("/admin").hasRole("ADMIN") 
				.requestMatchers("/my/**").hasAnyRole("ADMIN","USER")
				.anyRequest().denyAll()
				); // 접근 권한 설정
		
		 http
         .formLogin((auth) -> auth.loginPage("/login") // 잘못된 접근 시 자동으로 설정 경로로 리다이렉션 해줌
                 .loginProcessingUrl("/loginproc") // 프론트에서 넘어온 로그인정보를 받아 시큐리티가 로그인 진행
                 .permitAll() // 모든 접근 허용
         ); // 인증되지 않은 사용자가 권한이 없는 경로로 접근 시 다시 지정 경로로 redirection 하여 로그인 페이지를 보여줌 
		 	// => 스프링 시큐리티가 알아서 해줌
		    // 인증된 사용자가 권한이 없는 경로로 접근 시 403 오류 발생	

		 http
         .csrf((auth) -> auth.disable()); // 위변조 방지 시스템 (post 요청 시 토큰을 무조건 같이 보내줘야되기때문에 임의 설정)
		
		return http.build();
	}

}
