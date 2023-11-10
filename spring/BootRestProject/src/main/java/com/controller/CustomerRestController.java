package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.service.CustomerService;
import com.mybatis.vo.Customer;

import io.swagger.annotations.ApiOperation;

//@restcontroller : @controller + @responsebody(javaobject -> json)���� ��ȯ
@CrossOrigin(origins = {"*"})
@RestController
public class CustomerRestController {
	@Autowired
	CustomerService service;
	
	//requestMapping�̶� �Ȱ����� spring ���� �÷��� @GetMaping("/customers")
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	@ApiOperation("모든 고객 정보를 리턴하는 메소드")
	public List<Customer> selectAll(){
		return service.selectAll();
	}
	
	//http://localhost:8080/rest/customers/111
	
	@RequestMapping(value="/customers/{num}", method = RequestMethod.GET)
	@ApiOperation("num에 해당하는 고객 정보를 리턴하는 메소드")
	public Customer selectOne(@PathVariable String num){
		return service.selectOne(num);
	}
	
	@RequestMapping(value="/customers/{num}" , method = RequestMethod.DELETE)
	@ApiOperation("새 고객을 추가하는 메소드")
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
