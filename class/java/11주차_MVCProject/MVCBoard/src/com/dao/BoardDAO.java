package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vo.Board;

//DAO : db에 접근해서 crud를 수행하는 객체
public class BoardDAO implements IBoardDAO{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	
	@Override
	public ArrayList<Board> selectAll() {
		// TODO Auto-generated method stub
		String query = "select num,name,title,wdate,count from board order by num desc";
		ArrayList<Board> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String title = rs.getString(3);
				String wdate = rs.getString(4);
				int count = rs.getInt(5);
				//String num, String pass, String name, String wdate, String title, String content, int count
				Board b = new Board(num,null,name,wdate,title,null,count);
				list.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public BoardDAO() { //client에 의해 호출됨
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	@Override
	public Board selectOne(String num) {
		// TODO Auto-generated method stub
		String query = "select num,name,title,wdate,count,content from board where num =" + num;
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		Board b = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				rs.toString();
				String num1 = rs.getString(1);
				String name = rs.getString(2);
				String title = rs.getString(3);
				String wdate = rs.getString(4);
				int count = rs.getInt(5);
				//increaseCount(num1, count);
				String content = rs.getString(6);
				b = new Board(num1,null,name,wdate,title,content,count);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public void increaseCount(String num) {
        String query = "update board set count = count + 1 where num = ?";
        Board b = null;
        
        Connection con = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        
        try {
            con = getConnection(); // 2
            pstat = con.prepareStatement(query); // 3
            pstat.setString(1, num);
            pstat.executeUpdate(); // 4
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        close(rs, null, pstat, con);
    }
	public void close(ResultSet rs, Statement stat, PreparedStatement pstat, Connection con) {
		try {
			if(rs != null) rs.close();
			if(stat != null)stat.close();
			if(pstat != null)pstat.close();
			if(con != null)con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Board b) {
		String query =  "insert into board(pass, name, title, content, wdate) "
				+ "values(?,?,?,?, SYSDATE())";
		
		Connection con = null;
		PreparedStatement pstat = null;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			
			pstat.setString(1, b.getPass());
			pstat.setString(2, b.getName());
			pstat.setString(3, b.getTitle());
			pstat.setString(4, b.getContent());
			
			pstat.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("중복된 값이 있습니다");
		}
		
		close(null, null, pstat, con);
		
	}

	@Override
	public void delete(String num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Board> search(String condition, String word) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void countUp(String num) {
		Connection con = getConnection();
		String q = "update board set count = count + 1 where num = ?";
		
	}

}
