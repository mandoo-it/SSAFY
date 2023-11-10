package com.ssafy.pms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pms.service.PhoneService;
import com.ssafy.pms.vo.Phone;
import com.ssafy.pms.vo.User;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
public class PhoneRestController {
	@Autowired
	PhoneService service;
	
	@GetMapping("/phone")
	@ApiOperation("전체 폰 목록 조회.")
	public ResponseEntity<List<Phone>> list(){
		List<Phone> list = service.selectAll();
		if (list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Phone>>(list, HttpStatus.OK);
	}	
	
	@GetMapping("/phone/{num}")
	@ApiOperation("선택한 폰 정보 조회.")
	public ResponseEntity<Phone> view(@PathVariable String num) {
		Phone p = service.selectOne(num);
		if(p == null)
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Phone>(p, HttpStatus.OK);
	}	
	
	@PostMapping("/phone")
	@ApiOperation("새로운 폰 등록.")
	public ResponseEntity<Map> insert(@RequestBody Phone phone) {
		Map<String, String> map=new HashMap<String, String>();
		try {
			service.insert(phone);
			map.put("result", "insert success");
			return new ResponseEntity<Map>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("result", e.getMessage());
			return new ResponseEntity<Map>(map, HttpStatus.OK);
		}
	}	
	
	@PutMapping("/phone")
	@ApiOperation("선택한 폰 정보 수정.")
	public ResponseEntity<Map> update(@RequestBody Phone phone) {
		Map<String, String> map=new HashMap<String, String>();
		try {
			service.update(phone);
			map.put("result", "update success");
			return new ResponseEntity<Map>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("result", e.getMessage());
			return new ResponseEntity<Map>(map, HttpStatus.OK);
		}
	}	
	
	@DeleteMapping("/phone/{num}")
	@ApiOperation("선택한 폰 삭제.")
	public ResponseEntity<Map> delete(@PathVariable String num) {
		Map<String, String> map=new HashMap<String, String>();
		try {
			service.delete(num);
			map.put("result", "delete success");
			return new ResponseEntity<Map>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("result", e.getMessage());
			return new ResponseEntity<Map>(map, HttpStatus.OK);
		}
	}	
	@GetMapping("/login/{id}")
	public ResponseEntity<User> login(@PathVariable String id, HttpSession session) {
		User user = service.selectUser(id);
		if(user != null) {
			session.setAttribute("id", id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}	
	
	@GetMapping("/logout/{id}")
	public void logout(@PathVariable String id, HttpSession session) {
		session.setAttribute("id", null);
		session.invalidate();
	}
}
