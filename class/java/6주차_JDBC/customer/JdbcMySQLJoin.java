package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMySQLJoin {

	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
		String user = "scott";
		String password = "tiger";
		
		//empid, fname, deptname, city
		String Query = "select e.empid, e.fname, d.deptname, l.city from emp e left join dept d on e.deptid=d.deptid join loc l on d.locid=l.locid order by empid";

		try {

			// 1. Driver 등록(로딩) -> 사용할 DB 등록
			Class.forName(driver); // Class.forName(args[0]) 이런식으로 다른 종류의 객체를 가져오는게 편리하다. new Car() 이런식으로 하면 가져오는게
									// 불편함

			// 2. Connection 생성(Network 연결)
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. Statement 생성([Q:쿼리] 한개를 담을 수 있는 그릇
			Statement stat = con.createStatement();

			// 4. 쿼리 실행
			ResultSet rs = stat.executeQuery(Query);

			// 5. 결과처리
			while (rs.next()) {
				String empid = rs.getString(1);
				String fname = rs.getString(2);
				String email = rs.getString(3);
				System.out.println(empid + " : " + fname + " : " + email);
			}
			// 6.마무리
			rs.close();
			stat.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}