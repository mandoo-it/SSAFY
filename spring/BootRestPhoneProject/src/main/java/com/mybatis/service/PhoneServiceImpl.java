package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mybatis.dao.IPhoneDAO;
import com.mybatis.vo.Phone;
import com.mybatis.vo.User;

@Service("service")
public class PhoneServiceImpl implements IPhoneService {
	
	@Autowired
	IPhoneDAO dao;
	
	@Override
	public List<Phone> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Phone selectOne(String num) {
		return dao.selectOne(num);
	}

	@Override
	public int insert(Phone p) {
		return dao.insert(p);
	}

	@Override
	public int delete(String num) {
		return dao.delete(num);
	}

	@Override
	public int update(Phone phone) {
		return dao.update(phone);
	}

	@Override
	public User selectUser(String id) {
		User u = null;
		
		return dao.selectUser(id);
	}

}
