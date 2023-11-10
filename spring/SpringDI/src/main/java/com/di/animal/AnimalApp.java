package com.di.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {

	public static void main(String[] args) {
	//	ApplicationContext context = new ClassPathXmlApplicationContext("animal.xml");//컨테이너(기다리고있다가 요청이 들어오면 객체 생성해서 줌)
//		Animal l = (Lion) context.getBean("lion");
//		Animal t = (Tiger) context.getBean("tiger");
//		
//		l.info();
//		t.info();
//		zoo london = (LondonZoo)context.getBean("londonzoo");
//		london.info();
//		
//		zoo s = context.getBean("seoul", zoo.class);
//		s.info();
		ApplicationContext context = new ClassPathXmlApplicationContext("animalCollection.xml");
		zoo t = context.getBean("paris", zoo.class);
		t.info();
		
	}

}
