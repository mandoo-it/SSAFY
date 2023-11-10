package com.di.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configuration : 빈생성에 필요한 설정 정보를 가지고 있는 클래스. xml문서를 대신함
@Configuration
public class JavaConfig {
	//@Bean : 리턴타입의 객체를 생성해줌 <bean>태그와 동일
	//메소드 이름이 생성되는 빈의 id가 됨
	@Bean
	public Tiger getTiger() {
		Tiger t = new Tiger(3);
		t.setName("king");
		return t;
	}
	
	@Bean
	public Lion getLion() {
		Lion l = new Lion(2);
		l.setName("quuen");
		return l;
	}
}
