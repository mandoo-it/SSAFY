package com.di.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);//컨테이너를 생성하여 대기시켰다가 getbean요청오면 객체 return해주고
		
		Animal l = context.getBean("getTiger", Animal.class);
		Animal t = context.getBean("getLion", Animal.class);
		
		l.info();
		t.info();

		
	}

}
