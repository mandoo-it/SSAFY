package com.mybatis.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.service.CustomerService;
import com.mybatis.vo.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/mybatis-db.xml");
		CustomerService service = context.getBean("cus", CustomerService.class);
		
		Customer c1 = new Customer("10", "rolly", "seoul");
		try {
			service.insert2(c1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Customer> list = service.selectAll();
		
		
		for(Customer c : list) {
			System.out.println(c.getNum() + " "  + c.getName() + " " + c.getAddress());
		}
		

	}

}
