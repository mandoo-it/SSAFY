package com.ssafy.pms;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class IPhoneDAOImpl implements IPhoneDAO{

	@Autowired
	SqlSession session;
	
	@Override
	public void insert(Phone p) {
		session.insert("sql.pms.insert",p);
	}

	@Override
	public List<Phone> selectAll() {
		return session.selectList("sql.pms.selectAll");
	}

	@Override
	public Phone selectOne(String num) {
		return session.selectOne("sql.pms.selectOne", num);
	}

	@Override
	public void delete(String[] nums) {
		for(int i=0; i<nums.length; i++) {
			session.delete("sql.pms.delete", nums[i]);
		}
	}

	@Override
	public User login(String user) {
		
		return session.selectOne("sql.user.login", user);
	}

}
