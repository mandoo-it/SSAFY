package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MyBatisUtil;
import com.domain.Customer;

//mybatis를 이용해서 crud하는 작업
public class CustomerDAO implements ICustomer{

	@Override
	public List<Customer> selectAll() {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("Customer.selectAll"); //selectAll이라는 id를 가진 쿼리 실행 후 결과 return
	}

	@Override
	public Customer selectOne(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectOne("Customer.selectOne" , num);
	}

	@Override
	public int insert(Customer c) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int result = session.insert("Customer.insert",c);
		session.commit();
		return result;
	}

	@Override
	public int delete(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int result = session.insert("Customer.delete",num);
		session.commit();
		return result;
	}

	@Override
	public int update(String num, String address) {
		SqlSession session = MyBatisUtil.getSqlSession();
		Customer c = new Customer();
		c.setNum(num);
		c.setAddress(address);
		int result = session.insert("Customer.update",c);
		session.commit();
		return result;
	}

	@Override
	public List<Customer> findByAddress(String address) {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<Customer> result = session.selectList("Customer.findByAddress",address);
		session.commit();
		return result;
	}

}
