package com.app;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.CustomerDAO;
import com.dao.ICustomer;
import com.domain.Customer;


public class CustomerTest {

    public static void main(String[] args) {
        //dao 객체 생성 후 메소드 호출
    	ICustomer dao = new CustomerDAO();
    	List<Customer> list = dao.selectAll();
    	
    	for(Customer c : list) {
    		System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
    	}
    	
    	//System.out.println(dao.insert(new Customer( "301","kkyu", "서울시")));
    	//dao.update("301", "강남구");
    	//dao.delete("301");
    
    	for(Customer c : list) {
    		System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
    	}
    	System.out.println("--------------------------------------");
    	list = dao.findByAddress("seoul");
    	for(Customer c : list) {
    		System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
    	}
    }
}
