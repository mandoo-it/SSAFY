package com.ssafy.pms;

import java.util.List;

public interface IPhoneService {
	public void insert(Phone p);
	public List<Phone> selectAll();
	public Phone selectOne(String num);
	public void delete(String[] nums);
	public User login(String user);
}
