package com.dao;

import java.util.ArrayList;

import com.vo.Food;

public interface IFoodDAO {
	public ArrayList<Food> selectAll();
	public ArrayList<Food> search(String where, String sort1, String sort2, String word);
	public Food selectOne(String num);
	public void insert(Food b);
	public void delete(String num);
	public ArrayList<Food> searchMain(String parameter, String parameter2);
}
