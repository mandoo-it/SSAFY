package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybatis.vo.Board;

@Component("bdao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession session;

	@Override
	public List<Board> selectAll() {
	
		return session.selectList("board.selectAll");
	}

	@Override
	public Board selectOne(String num) {
		// TODO Auto-generated method stub
		countUp(num);
		return session.selectOne("board.selectOne",num);
	}

	@Override
	public void insert(Board c) {
		session.insert("board.insert", c);
		//session.commit();
	}

	@Override
	public void delete(String num) {
		session.delete("board.delete", num);
		//session.commit();
	}

	@Override
	public void update(Board b) {
		session.update("board.update", b);
		//session.commit();
	}

	@Override
	public List<Board> findByTitle(String title) {
		
		return session.selectList("board.findByTitle", title);
	}

	@Override
	public List<Board> findByName(String name) {
		// TODO Auto-generated method stub
		return session.selectList("board.findByName", name);
	}

	@Override
	public List<Board> findByTitle2(String title) {
		// TODO Auto-generated method stub
		return session.selectList("board.findByTitle2", "%"+title+"%");
	}

	@Override
	public void delete2(String[] nums) {
		session.delete("board.delete2",nums);
		//session.commit();
	}
	
	public void countUp(String num) {
		session.update("board.countUp", num);
		//session.commit();
	}
	
	

}
