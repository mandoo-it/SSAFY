package com.ssafy.pms;

import java.util.List;

public interface IPhoneService {
	List<Phone> selectAll();
	Phone selectOne(String num);
	void insert(Phone p);
	void delete(String[] nums);
	boolean loginCheck(String id, String pw);
}
