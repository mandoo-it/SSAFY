package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mybatis.vo.Customer;

//CLIENT(customerSercviceImple)
//dao 객체 : CRUD작업을 함
// 실제로 sqlSession객체를 주입 받아 crud 작업 수행
//@Component("dao")
@Repository("dao")
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	SqlSession session;//session가지고 쿼리를 날리 때 마다 계속 새로운 세션을 만드는 것(한개로 작업한는 거 아님)
	
	@Override
	public List<Customer> selectAll() {
		System.out.println(session);
		return session.selectList("customer.selectAll");
	}

	@Override
	public Customer selectOne(String num) {
		return session.selectOne("customer.selectOne", num);
	}

	@Override
	public int insert(Customer c) {
		return session.insert("customer.insert", c);
	}

	@Override
	public int delete(String num) {
		return session.delete("customer.delete", num);
	}

	@Override
	public int update(Customer c) {
		return session.delete("customer.update", c);
	}

	@Override
	public List<Customer> findByAddress(String address) {
		return session.selectList("customer.findByAddress", address);
	}

	
	

}
