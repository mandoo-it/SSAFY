package com.ssafy.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	public void insert(Phone p) {
		dao.insert(p);
	}
	@Override
	public void delete(String[] nums) {
		dao.delete(nums);
	}
	@Override
	public boolean loginCheck(String id, String pw) {
		return dao.loginCheck(id, pw);
	}
}
