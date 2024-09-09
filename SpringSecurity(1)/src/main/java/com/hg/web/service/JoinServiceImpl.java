package com.hg.web.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hg.web.dto.JoinDto;
import com.hg.web.mapper.UserMapper;
import com.hg.web.vo.prouser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService {
	
	private final UserMapper usermapper;
	private final BCryptPasswordEncoder bpe;
//	public JoinService(UserRepository userrepository,BCryptPasswordEncoder bpe) {
//		this.userrepository=userrepository;
//		this.bpe=bpe;
//	}
	
	public boolean Joinprocess(JoinDto joindto) {
		 
		prouser data=new prouser();
		int count=usermapper.countID(joindto.getUsername());
		try {
			
			if(count>0) {
				System.out.println("이미 존재하는 아이디");
				return false;
			}
			
			data.setUsername(joindto.getUsername());
			System.out.println("joinservice 실행");
			data.setPassword(bpe.encode(joindto.getPassword())); // 비밀번호 암호화
			data.setRole("ADMIN");
				
			usermapper.Joinprocess(data);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return true;
	}
}
