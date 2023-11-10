package com.dao;

import java.util.*;
import com.domain.Customer;
public interface ICustomer {
//client를 위한 서비스 메소드를 가지고있는 인터페이스
		List<Customer> selectAll();
		Customer selectOne(String num);
		int insert(Customer c);
		int delete(String num);
		int update(String num, String address);
		List<Customer> findByAddress(String address);
}
