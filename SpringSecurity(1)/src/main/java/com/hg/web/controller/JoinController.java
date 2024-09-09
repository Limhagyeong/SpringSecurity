package com.hg.web.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hg.web.dto.JoinDto;
import com.hg.web.service.JoinService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JoinController {
	
	private final JoinService joinservice;
	
//	public JoinController(JoinService joinservice) {
//		// TODO Auto-generated constructor stub
//		this.joinservice=joinservice;
//	} => 생성자 주입 방식

	
	@GetMapping("/join")
	public String joinp(){
		return "join";
	}
	@PostMapping("/joinProc")
	public String joinorocess(JoinDto joindto){
		
		boolean res=joinservice.Joinprocess(joindto);
		
		if(!res) {
			System.out.println("회원가입실패");
			return "redirect:/join";
		}
		
		return "redirect:/login";
	}
}
