package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vo.Food;

public class FoodDAO implements IFoodDAO{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	
	@Override
	public ArrayList<Food> selectAll() {
		String query = "select code,name,material,img from Foods order by code desc";
		ArrayList<Food> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				Food result = new Food();
                result.setCode(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setMaterial(rs.getString(3));
                result.setImg(rs.getString(4));
				list.add(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public FoodDAO() { //client에 의해 호출됨
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
	@Override
	public Food selectOne(String num) {
		String query = "select * from Foods where code =" + num;
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		Food result = new Food();
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
                result.setCode(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setSupportpereat(rs.getDouble(3));
                result.setCalory(rs.getDouble(4));
                result.setCarbo(rs.getDouble(5));
                result.setProtein(rs.getDouble(6));
                result.setFat(rs.getDouble(7));
                result.setSugar(rs.getDouble(8));
                result.setNatrium(rs.getDouble(9));
                result.setChole(rs.getDouble(10));
                result.setFattyacid(rs.getDouble(11));
                result.setTransfat(rs.getDouble(12));
                result.setMaker(rs.getString(13));
                result.setMaterial(rs.getString(14));
                result.setImg(rs.getString(15));
                result.setAllergy(rs.getString(16));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Food c) {
		String query = "insert into Food (pass,name,title,content,wdate) values(?,?,?,?,SYSDATE())";
		Connection con = null;
		PreparedStatement pstat = null;
		int rs = 0;
		
		try {
			con = getConnection();
			pstat = con.prepareStatement(query);
			
//			pstat.setString(1, c.getPass());
//			pstat.setString(2, c.getName());
//			pstat.setString(3, c.getTitle());
//			pstat.setString(4, c.getContent());
			
			rs = pstat.executeUpdate(); 
			System.out.println(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String num) {
		String query = "delete from Food where num = " + num;
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


//	@Override
//	public ArrayList<Food> search(String condition, String word) {
//		return null;
//	}

	
	public void close(ResultSet rs, Statement stat, PreparedStatement pstat, Connection con) {
		try {
			if(rs != null) rs.close();
			if(stat != null)stat.close();
			if(pstat != null)pstat.close();
			if(con != null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void increaseCount(String num) {
        String query = "update Food set count = count+1 where num = ?";
        Food b = null;
        
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

	@Override
	public ArrayList<Food> search(String where, String sort1, String sort2, String word) {
		String query = "select code,name,material,img from Foods where "+where+" like '%"+word+"%' order by " + sort1 +" " +sort2;
		ArrayList<Food> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				Food result = new Food();
                result.setCode(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setMaterial(rs.getString(3));
                result.setImg(rs.getString(4));
				list.add(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Food> searchMain(String where, String word) {
		String query = "select code,name,material,img from Foods where " + where + " like '%" + word
                + "%' order by code desc";
        ArrayList<Food> list = new ArrayList<>();
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            stat = con.createStatement();
            rs = stat.executeQuery(query);
            while (rs.next()) {
                Food result = new Food();
                result.setCode(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setMaterial(rs.getString(3));
                result.setImg(rs.getString(4));
                list.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

}
