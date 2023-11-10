package com.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.service.CustomerService;
import com.mybatis.vo.Customer;

//@restcontroller : @controller + @responsebody(javaobject -> json)���� ��ȯ
@RestController
public class CustomerRestController {
	@Autowired
	CustomerService service;
	
	//requestMapping�̶� �Ȱ����� spring ���� �÷��� @GetMaping("/customers")
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public List<Customer> selectAll(){
		return service.selectAll();
	}
	
	//http://localhost:8080/rest/customers/111
	@RequestMapping(value="/customers/{num}", method = RequestMethod.GET)
	public Customer selectOne(@PathVariable String num){
		return service.selectOne(num);
	}
	
	@RequestMapping(value="/customers/{num}" , method = RequestMethod.DELETE)
	public Map delete(@PathVariable String num) {
		service.delete(num);
		Map map = new HashMap();
		map.put("result", "delete success!!");
		return map;
	}
	
	@RequestMapping(value="/customers" , method = RequestMethod.POST)
	public Map insert(@RequestBody Customer c) {//RequestBody : Request안의 json -> java object:로 변환
		service.insert(c);
		Map map = new HashMap();
		map.put("result", "insert success!!");
		return map;
		
	}
	
	@RequestMapping(value="/customers" , method = RequestMethod.PUT)
	public Map update(@RequestBody Customer c) {//RequestBody : Request안의 json -> java object:로 변환
		service.update(c);
		Map map = new HashMap();
		map.put("result", "update success!!");
		return map;
		
	}
}
