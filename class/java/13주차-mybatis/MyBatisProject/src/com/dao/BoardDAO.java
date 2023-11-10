package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MyBatisUtil;
import com.domain.Board;
import com.domain.Customer;

//mybatis를 이용해서 crud하는 작업
public class BoardDAO implements IBoard{

	@Override
	public List<Board> selectAll() {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("board.selectAll"); //selectAll이라는 id를 가진 쿼리 실행 후 결과 return
	}

	@Override
	public Board selectOne(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectOne("board.selectOne" , num);
	}

	@Override
	public int insert(Board b) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int result = session.insert("board.insert",b);
		session.commit();
		return result;
	}

	@Override
	public int delete(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int result = session.insert("board.delete",num);
		session.commit();
		return result;
	}

	@Override
	public List<Board> search(String condition, String word) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("board.search", word); //selectAll이라는 id를 가진 쿼리 실행 후 결과 return
		/*
	     * public List<Customer> searchAll(String condition, String word){
	     * SqlSession session = MyBatisUtil.getSqlSession();
	     * HashMap<String, String> map = new HashMap<String, String>;
	     *
	     * map.put("key",condition);//검색 기준
	     * map.put("word",word);//검색어
	     * return session.selectList("customer.selectAll",map);
	     *
	     * */
	}

	


}
