package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.service.IPhoneService;
import com.mybatis.vo.Phone;
import com.mybatis.vo.User;

import io.swagger.annotations.ApiOperation;

@RestController
public class IPhoneRestController {
	@Autowired
	IPhoneService service;
	
	@RequestMapping(value="/phones", method = RequestMethod.GET)
	@ApiOperation("전체 정보 가져오기")
	public List<Phone> selectAll(){
		return service.selectAll();
	}
	
	//http://localhost:8080/rest/customers/111
	@RequestMapping(value="/phones/{num}", method = RequestMethod.GET)
	@ApiOperation("num에 해당하는 글 가져오기")
	public Phone selectOne(@PathVariable String num){
		return service.selectOne(num);
	}
	
	@RequestMapping(value="/phones/{num}" , method = RequestMethod.DELETE)
	@ApiOperation("num에 해당하는 글 삭제")
	public Map<String,String> delete(@PathVariable String num) {
		service.delete(num);
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "delete success!!");
		return map;
	}
	
	@RequestMapping(value="/phones" , method = RequestMethod.POST)
	@ApiOperation("새 글 추가하는 메소드")
	public Map<String,String> insert(@RequestBody Phone c) {//RequestBody : Request안의 json -> java object:로 변환
		service.insert(c);
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "insert success!!");
		return map;
		
	}
	
	@RequestMapping(value="/phones" , method = RequestMethod.PUT)
	@ApiOperation("phone 정보 수정하는 메소드")
	public Map<String,String> update(@RequestBody Phone p) {//RequestBody : Request안의 json -> java object:로 변환
		service.update(p);
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "update success!!");
		return map;
		
	}
	
	@RequestMapping(value="/login/{id}/{pw}" , method = RequestMethod.GET)
	@ApiOperation("phone 정보 수정하는 메소드")
	public Boolean login(@PathVariable String id,@PathVariable String pw, HttpSession session) {//RequestBody : Request안의 json -> java object:로 변환
		User user = service.selectUser(id);
		
		if(user != null) {
			if(user.getPw().equals(pw)) {
				session.setAttribute("user", user.getId());
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	@ApiOperation("phone 정보 수정하는 메소드")
	public void logout(HttpSession session) {
		session.setAttribute("user", null);
		session.invalidate();
	}
}
