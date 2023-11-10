package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mybatis.dao.CustomerDao;
import com.mybatis.vo.Customer;

//CLIENT(ClientApp.java)媛� getBean�빐�꽌 �궗�슜�븯�뒗 媛앹껜
//�꽌鍮꾩뒪 媛앹껜
//CustomerDAOImpl媛앹껜瑜� 二쇱엯 諛쏆븘 dao�뿉 �옉�뾽 吏��떆
//@Component("cus")
@Service("cus")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao dao;//type湲곗��쑝濡� 二쇱엯. �떎�젣濡� CustomerDaoImpl�뿉 二쇱엯�맖
	@Override
	public List<Customer> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Customer selectOne(String num) {
		return dao.selectOne(num);
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
		int x = dao.update(c);
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
