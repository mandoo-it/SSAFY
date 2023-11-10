package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertPre {

	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver";
		// jdbc url
		// jdbc는 protocol 이름, 의사소통할때 사용하는 도구, mysql은 db, localhost : db서버 주소, 3306 포트,
		// scott : 스키마이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
		String user = "scott";
		String password = "tiger";
		String Query = "insert into customer values(" + args[0] + ",'" + args[1] + "','" + args[2] + "')";
		System.out.println(Query);
		try {

			// 1. Driver 등록(로딩) -> 사용할 DB 등록
			Class.forName(driver); // Class.forName(args[0]) 이런식으로 다른 종류의 객체를 가져오는게 편리하다. new Car() 이런식으로 하면 가져오는게
									// 불편함

			// 2. Connection 생성(Network 연결)
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. Statement 생성([Q:쿼리] 한개를 담을 수 있는 그릇
			Statement stat = con.createStatement();
			
			// 4. 쿼리 실행
			int rs = stat.executeUpdate(Query);

			// 5. 결과처리
			System.out.println(rs + "개의 레코드 추가");
			// 6.마무리

			stat.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}