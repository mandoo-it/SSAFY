package com.mybatis.dao;

import java.util.List;

import com.mybatis.vo.Customer;

public interface CustomerDao {
	List<Customer> selectAll();
	Customer selectOne(String num);
	int insert(Customer c);
	int delete(String num);
	int update(Customer c);
	List<Customer> findByAddress(String address);

}
