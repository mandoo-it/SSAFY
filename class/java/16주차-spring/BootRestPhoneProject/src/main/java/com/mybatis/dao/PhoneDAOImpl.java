package com.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mybatis.vo.Phone;
import com.mybatis.vo.User;

@Repository("dao")
public class PhoneDAOImpl implements IPhoneDAO {

	@Autowired
	SqlSession session;
	
	@Override
	public List<Phone> selectAll() {
		List<Phone> list=session.selectList("sql.pms.selectAll");
		return list;
	}
	@Override
	public Phone selectOne(String num) {
		Phone p=session.selectOne("sql.pms.selectOne", num);
		return p;
	}
	@Override
	public int insert(Phone p) {
		return session.insert("sql.pms.insert",p);
	}
	@Override
	public int delete(String num) {
		return session.delete("sql.pms.delete", num);
	}
	@Override
	public int update(Phone phone) {
		return session.update("sql.pms.update", phone);
	}
	@Override
	public User selectUser(String id) {
		return session.selectOne("sql.pms.selectUser", id);
	}
	
	
}
