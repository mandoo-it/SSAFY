package com.mybatis;

import java.sql.*;

public class JdbcExecute {

	public static void main(String args[]) {
		String db_connect = new String("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
		String db_user = new String("scott");
		String db_passwd = new String("tiger");
		
		String str1 = "select * from customer";
		String str2 = "insert into customer values(987,'hee','la')";

		Connection conn;
		Statement stat;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection (db_connect, db_user, db_passwd);
			
			stat = conn.createStatement();

			boolean flag = stat.execute(str1); 
	//		boolean flag = stat.execute(str2); 

			if(flag == true){
				ResultSet rs = stat.getResultSet();

				while(rs.next()) {
					String num  = rs.getString(1);
					String name  = rs.getString(2);
					String address   = rs.getString(3);
					System.out.println(num + "-- " +name + "-- " + address );
				}
			}			
			else{
				int rows = stat.getUpdateCount();
				if (rows != 0)
					System.out.println("operation ok....!!!");
				else 
					System.out.println("no changes made...!!!");
			}
			stat.close();
			conn.close();
		} catch ( Exception e ) {
			System.out.println(" error sql");
			e.printStackTrace();
		}
	}
}