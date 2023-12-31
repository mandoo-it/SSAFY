package com.mybatis.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mybatis.vo.Board;

public interface BoardDao {
	public List<Board> selectAll();
	public Board selectOne(String num);
	public void insert(Board c);
	public void delete(String num);
	public void update(Board b);
	public List<Board> findByTitle(String title);
	public List<Board> findByName(String name);
	
	@Transactional
	public List<Board> findByTitle2(String title);//like 검색
	public void delete2(String[] nums);//여러개의 글 한꺼번에 삭제
	
}
