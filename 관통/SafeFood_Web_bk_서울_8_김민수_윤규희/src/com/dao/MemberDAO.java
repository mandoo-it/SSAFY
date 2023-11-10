package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.vo.Food;
import com.vo.Member;


public class MemberDAO implements IMemberDAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	@Override
	public Member search(String id) throws SQLException {
		String query = "select * from member where id = '" + id+"'";
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		Member result = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
			  result = new Member();
              result.setId(rs.getString(1));
              result.setPassword(rs.getString(2));
              result.setName(rs.getString(3));
              result.setEmail(rs.getString(4));
              result.setAddress(rs.getString(5));
              result.setPhone(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void add(Member member) throws SQLException {
		String query = "insert into member values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstat = null;
		int rs = 0;
		
		try {
			con = getConnection();
			pstat = con.prepareStatement(query);
			
			pstat.setString(1, member.getId());
			pstat.setString(2, member.getPassword());
			pstat.setString(3, member.getName());
			pstat.setString(4, member.getEmail());
			pstat.setString(5, member.getAddress());
			pstat.setString(6, member.getPhone());
			pstat.setString(7, member.getAl());
			
			
			rs = pstat.executeUpdate(); 
			System.out.println(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Member member) throws SQLException {
		String query = " update member set password=?, name=?, email=?, address=? ,phone=?,al=? where id=? " ;
		Connection con = null;
		PreparedStatement pstat = null;
		int rs = 0;
		try {
			con = getConnection();
			pstat = con.prepareStatement(query);
			
			
			pstat.setString(1, member.getPassword());
			pstat.setString(2, member.getName());
			pstat.setString(3, member.getEmail());
			pstat.setString(4, member.getAddress());
			pstat.setString(5, member.getPhone());
			pstat.setString(6, member.getAl());
			pstat.setString(7, member.getId());
			
			
			rs = pstat.executeUpdate(); 
			System.out.println(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) throws SQLException {
		String query = "delete from member where id = '" + id+"'";
		Connection con = null;
		PreparedStatement pstat = null;
		int rs = 0;
		try {
			con = getConnection();
			pstat = con.prepareStatement(query);
			rs = pstat.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberDAO() { //client에 의해 호출됨
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}







