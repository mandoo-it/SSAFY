package com.di.animal;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("seoul")
public class SeoulZoo implements zoo{
	//@Autowired : 자동주입(타입 기준 : xml문서를 읽어서 생성한 객체 중에 타입이 동일하면 자동으로 주입시켜 줌)
	//@Component : container의 bean객체로 자동 등록시켜줌
	
	@Autowired
	Tiger tiger;
	@Autowired
	@Qualifier("tommy") //원하는 이름을 딱 명시
	Lion lion2;
	
	@Override
	public void info() {
		lion2.info();
		tiger.info();
		
	}

	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}

	public void setLion(Lion lion) {
		this.lion2 = lion;
	}

}
