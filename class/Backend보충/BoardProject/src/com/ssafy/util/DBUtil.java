package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static String url = "jdbc:mysql://localhost:3306/tommy?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	static String user= "scott";
	static String pw  = "tiger";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("driver loading 실패");
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, pw);
	}
	public static void close(Connection con) {
		if(con != null) {
			try { con.close();	} catch (Exception e) {}
		}
	}
	public static void close(PreparedStatement stmt) {
		if(stmt != null) {
			try { stmt.close();	} catch (Exception e) {}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {
			try { rs.close();	} catch (Exception e) {}
		}
	}
	public static void rollback(Connection con) {
		if(con != null) {
			try {
				con.rollback();
			} catch (Exception e) {}
		}
	}
}














