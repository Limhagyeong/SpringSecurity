package com.hg.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hg.web.dto.JoinDto;
import com.hg.web.vo.prouser;
@Repository
@Mapper
public interface UserMapper {
	// 회원가입 중복 방지
	int countID(String username);
	// 회원가입
	public void Joinprocess(prouser data);
	// 로그인 검증
	prouser findID(String username);
}
