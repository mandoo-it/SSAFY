package com.ssafy.pms;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
	public void insert(Phone p) {
		session.insert("sql.pms.insert",p);
	}
	@Override
	public void delete(String[] nums) {
		for(int i=0; i<nums.length; i++) {
			session.delete("sql.pms.delete", nums[i]);
		}
	}
	@Override
	public boolean loginCheck(String id, String pw) {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		if(session.selectOne("sql.pms.login", map)==null) return false;
		return true;
	}
}
