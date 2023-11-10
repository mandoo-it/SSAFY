package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mybatis.dao.CustomerDao;
import com.mybatis.vo.Customer;

//CLIENT(ClientApp.java)가 getBean해서 사용하는 객체
//서비스 객체
//CustomerDAOImpl객체를 주입 받아 dao에 작업 지시
//@Component("cus")
@Service("cus")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao dao;//type기준으로 주입. 실제로 CustomerDaoImpl에 주입됨
	@Override
	public List<Customer> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Customer selectOne(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Customer c) {
		int x = dao.insert(c);
		return x;
	}

	@Override
	public int delete(String num) {
		int x = dao.delete(num);
		return x;
	}

	@Override
	public int update(Customer c) {
		int x = dao.insert(c);
		return x;
	}

	@Override
	public List<Customer> findByAddress(String address) {
		return dao.findByAddress(address);
	}

	@Override
	public int insert2(Customer c) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(c);
		dao.insert(c);
		return 0;
	}
	

}
