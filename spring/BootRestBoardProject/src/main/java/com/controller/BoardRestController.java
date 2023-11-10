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

import com.mybatis.service.BoardService;
import com.mybatis.vo.Board;

import io.swagger.annotations.ApiOperation;

//@restcontroller : @controller + @responsebody(javaobject -> json)���� ��ȯ
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
public class BoardRestController {
	@Autowired
	BoardService service;
	
	//requestMapping�̶� �Ȱ����� spring ���� �÷��� @GetMaping("/customers")
	@RequestMapping(value="/boards", method = RequestMethod.GET)
	@ApiOperation("새 글 추가하는 메소드")
	public List<Board> selectAll(){
		return service.selectAll();
	}
	
	//http://localhost:8080/rest/customers/111
	@RequestMapping(value="/boards/{num}", method = RequestMethod.GET)
	@ApiOperation("num에 해당하는 글 가져오기")
	public Board selectOne(@PathVariable String num){
		return service.selectOne(num);
	}
	
	@RequestMapping(value="/boards/{num}" , method = RequestMethod.DELETE)
	@ApiOperation("num에 해당하는 글 삭제")
	public Map<String,String> delete(@PathVariable String num) {
		service.delete(num);
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "delete success!!");
		return map;
	}
	
	@RequestMapping(value="/boards" , method = RequestMethod.POST)
	public Map<String,String> insert(@RequestBody Board c) {//RequestBody : Request안의 json -> java object:로 변환
		service.insert(c);
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "insert success!!");
		return map;
		
	}
	
	@RequestMapping(value="/boards" , method = RequestMethod.PUT)
	public Map<String,String> update(@RequestBody Board c) {//RequestBody : Request안의 json -> java object:로 변환
		service.update(c);
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "update success!!");
		return map;
		
	}
	
	@RequestMapping(value="/boards/{condition}/{word}" , method = RequestMethod.GET)
	public List<Board> search(@PathVariable String condition, @PathVariable String word) {//RequestBody : Request안의 json -> java object:로 변환
		if(condition.equals("name")) {
			return service.findByName(word);
		} else if(condition.equals("title")){
			return service.findByTitle2(word);
		} else return service.selectAll();
		
	}
}
