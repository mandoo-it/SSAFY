package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.Member;

public interface IMemberDAO {
	public Member search( String id) throws SQLException;
	public void add(Member member)	 throws SQLException;
	public void update(Member member)throws SQLException;
	public void remove(String id)    throws SQLException;
}












