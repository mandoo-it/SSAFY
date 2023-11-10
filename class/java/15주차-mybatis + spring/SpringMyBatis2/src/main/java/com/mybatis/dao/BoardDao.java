package com.mybatis.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mybatis.vo.Board;
import com.mybatis.vo.Customer;

public interface BoardDao {
	
	public List<Board> selectAll();
	public Board selectOne(String num);
	public void insert(Board c);
	public void delete(String num);
	public void update(Board b);
	public List<Board> findByTitle(String title);
	public List<Board> findByName(String name);
	public List<Board> findByTitle2(String title);
	public void delete2(String[] nums);

}
