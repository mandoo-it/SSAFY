package com.mybatis.service;

import java.util.List;

import com.mybatis.vo.Phone;
import com.mybatis.vo.User;

public interface IPhoneService {
	List<Phone> selectAll();
	Phone selectOne(String num);
	int insert(Phone p);
	int delete(String num);
	int update(Phone phone);//num 기준으로 model, price 수정
	User selectUser(String id);//login check
}
