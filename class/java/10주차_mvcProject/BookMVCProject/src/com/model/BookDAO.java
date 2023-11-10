package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO : db에 접근해서 crud를 수행하는 객체
public class BookDAO implements IBookDAO{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tommy?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	
	@Override
	public ArrayList<Book> selectAll() {
		// TODO Auto-generated method stub
		String query = "select * from book order by isbn";
		ArrayList<Book> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			System.out.println(con==null);
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				String isbn1 = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				int price = Integer.parseInt(rs.getString(5));
				String description = rs.getString(6);
				Book b = new Book(isbn1, title, author,publisher,price,description);
				list.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public BookDAO() { //client에 의해 호출됨
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
	public Book selectOne(String isbn) {
		// TODO Auto-generated method stub
		String query = "select * from book where isbn =" + isbn;
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		Book b = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				rs.toString();
				String isbn1 = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				int price = Integer.parseInt(rs.getString(5));
				String description = rs.getString(6);
				b = new Book(isbn1, title, author,publisher,price,description);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public int insert(Book b) {
		// TODO Auto-generated method stub
		String query = "insert into book values(" + b.getIsbn() + ",'" +b.getTitle() + "','" + b.getAuthor()  + "','" + b.getPublisher() + "','" + b.getPrice() +  "','" + b.getDesc() + "')";
		Connection con = null;
		PreparedStatement pstat = null;
		int rs = 0;
		
		try {
			con = getConnection();
			pstat = con.prepareStatement(query);
			rs = pstat.executeUpdate(query); 
			System.out.println("sucess");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int delete(String isbn) {
		// TODO Auto-generated method stub
		String query = "delete from book where isbn = " + isbn;
		Connection con = null;
		PreparedStatement pstat = null;
		int rs = 0;
		
		try {
			con = getConnection();
			pstat = con.prepareStatement(query);
			rs = pstat.executeUpdate(); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
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
}
