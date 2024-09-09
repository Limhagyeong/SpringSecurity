package com.hg.web.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hg.web.service.SecSessionServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Maincontroller {
	
	private final SecSessionServiceImpl sss;
	
	@GetMapping("/")
	public String main(Model model){
		
		Map<String, String> sessiondata=sss.secSession();
		
		String id=sessiondata.get("id");
		String role=sessiondata.get("role");
		
		model.addAttribute("id",id); // 모델 객체는 C에서 생성된 데이터를 V로 전달하기 위해 사용됨
		model.addAttribute("role",role);
		
		System.out.println("mc 호출");
		
		return "main";
	}
}
