package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.domain.Customer;

//DAO:DB에 접근해서 CRUD(Create/Read/Update/Delete) 작업을 수행하는 객체
public class CustomerDAO implements ICustomer {

	// FIELD
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";

	// 생성자:1.Driver 등록-> 앞으로 사용할 db 등록
	public CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2.Connection 생성 - network 연결	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		String q = "select * from customer order by num";
		ArrayList<Customer> list = new ArrayList<>();

		try {
			Connection con = getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);

			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);

				Customer c = new Customer(num, name, address);
				list.add(c);
			}

			close(stat, rs, con, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer selectOne(String num) {
		String query = "select * from customer where num = ?";
		Customer c = null;
		//insert랑 update는 executeUpdate()
		try {
			Connection con = getConnection(); //connection가져오기
			PreparedStatement pstat = con.prepareStatement(query);//
			pstat.setString(1, num);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				String num1 = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);

				c = new Customer(num1, name, address);
			}

			close(pstat, rs, con, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String num, String address) {
		String query = "update customer set address = ? where num = ?";
		int rs = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, num);
			ps.setString(2, num);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int delete(String num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void close(Statement stat, ResultSet rs, Connection con, PreparedStatement pstat) {
		try {
			if (stat != null)
				stat.close();			
			if (pstat != null)
				pstat.close();
			
			if (rs != null)
				rs.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



}
