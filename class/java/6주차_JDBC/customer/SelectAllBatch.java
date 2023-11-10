package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllBatch {

	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
		String user = "scott";
		String password = "tiger";
		Connection con = null;

		try {

			// 1. Driver 등록(로딩) -> 사용할 DB 등록
			Class.forName(driver); // Class.forName(args[0]) 이런식으로 다른 종류의 객체를 가져오는게 편리하다. new Car() 이런식으로 하면 가져오는게
									// 불편함

			// 2. Connection 생성(Network 연결)
			con = DriverManager.getConnection(url, user, password);

			// 3. Statement 생성([Q:쿼리] 한개를 담을 수 있는 그릇
			Statement stat = con.createStatement();
			
			// 3.1. batch에 query 추가
			stat.addBatch("insert into customer values(25,'harry', 'la')");
			stat.addBatch("insert into customer values(26,'jerry', 'la')");
			stat.addBatch("insert into customer values(27,'marry', 'la')");
			
			// 4. 쿼리 실행
			con.setAutoCommit(false);
			int[] a = stat.executeBatch();
			con.commit();
			
			System.out.println("commit all...");
			// 6.마무리
			stat.close();
			con.close();

		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("rollback all?");
			}catch(SQLException e1){
				e.printStackTrace();
			}
			
			
		}

	}

}