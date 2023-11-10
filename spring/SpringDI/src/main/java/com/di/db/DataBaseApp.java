package com.di.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DataBaseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.ClassPathXmlApplicationContext 객체 생성(db.xml)
		ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");
		
		// 2.getBean("oracle"), getBean("mysql");
		DataService bean = (OracleDataService) context.getBean("oracle");
		DataService bean2 = (MySQLDataService) context.getBean("mysql");
		// 3.info() 호출
		bean.info();
		bean2.info();
		

	}

}
