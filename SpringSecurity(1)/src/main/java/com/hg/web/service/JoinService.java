package com.hg.web.service;

import com.hg.web.dto.JoinDto;
// 인터페이스를 통해 controller에서는 메소드의 구체적인 구현을 몰라도 됨
// => 다형성 : 부모 타입을 통해 자식 클래스 객체를 참조할 수 있기 때문
// 스프링 의존성 주입(DI)을 통해 @service로 등록된 구현체가 자동으로 주입됨 => 어떤 구현체를 사용할건지 정할 수 있음!
// 즉, 구현이 변하여도 컨트롤러를 수정해줄 필요 X
public interface JoinService {
	public boolean Joinprocess(JoinDto joindto);
}
