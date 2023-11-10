package com.util;
import java.util.*;
public class TreeMapRes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, String> tmap = new TreeMap<>();
		tmap.put("가", "가나다");
		tmap.put("a", "abc");
		tmap.put("A", "ABC");
		
		System.out.println(tmap);
		System.out.println(tmap.firstKey());
		System.out.println(tmap.lastKey());
		System.out.println(tmap.higherEntry("a"));
	}

}
