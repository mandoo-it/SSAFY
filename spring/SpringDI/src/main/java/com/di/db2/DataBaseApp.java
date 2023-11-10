package com.di.db2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.di.javaconfig.Animal;
import com.di.javaconfig.JavaConfig;


public class DataBaseApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);//컨테이너를 생성하여 대기시켰다가 getbean요청오면 객체 return해주고
		
		//DataService sql = context.getBean("getMysql", DataService.class);
		DataService sql = (DataService)context.getBean("getMysql");
		DataService oracle = context.getBean("getMyoracle", DataService.class);
		sql.info();
		oracle.info();
		

	}

}
