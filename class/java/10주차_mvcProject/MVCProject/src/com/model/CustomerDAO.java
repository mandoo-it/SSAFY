package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO : db에 접근해서 crud를 수행하는 객체
public class CustomerDAO implements ICustomerDAO{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	
	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		String query = "select * from customer order by num";
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				rs.toString();
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				Customer c = new Customer(num, name, address);
				list.add(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public CustomerDAO() { //client에 의해 호출됨
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
	public Customer selectOne(String num) {
		// TODO Auto-generated method stub
		String query = "select * from customer where num =" + num;
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		Customer c = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				rs.toString();
				String num1 = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				c = new Customer(num1, name, address);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int insert(Customer c) {
		// TODO Auto-generated method stub
		String query = "insert into customer values(" + c.getNum() + ",'" +c.getName() + "','" + c.getAddress() + "')";
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
	public int delete(String num) {
		// TODO Auto-generated method stub
		String query = "delete from customer where num = " + num;
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

	@Override
	public int update(String num, String address) {
		// TODO Auto-generated method stub
		String query = "update customer set address = '" + address + "' where num = " + num + "";
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

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		// TODO Auto-generated method stub
		String query = "select * from customer where address = '" + address + "'order by num";
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				rs.toString();
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address2 = rs.getString(3);
				Customer c = new Customer(num, name, address2);
				list.add(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
