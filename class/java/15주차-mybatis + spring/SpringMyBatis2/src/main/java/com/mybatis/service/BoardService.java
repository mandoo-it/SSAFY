package com.mybatis.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mybatis.vo.Board;

//client(BoardApp.java)를 위한 인터페이스
public interface BoardService {
	public List<Board> selectAll(); //
	public Board selectOne(String num); //
	public void insert(Board c); //
	public void delete(String num); //
	
	public void update(Board b); // 번호기준으로 제목과 내용수정
	
	public List<Board> findByTitle(String title);
	public List<Board> findByName(String name);
	
	
	public List<Board> findbyTitle2(String title);
	@Transactional
	public void delete2(String[] nums);
	
}
