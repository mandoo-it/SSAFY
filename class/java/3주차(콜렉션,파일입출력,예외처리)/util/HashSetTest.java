package com.util;

import java.util.HashSet;

public class HashSetTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		set.add("bill");
		set.add("jane");
		set.add("robert");
		set.add("kim");
		
		for(String name : set) {
			System.out.println(name);
		}
	}

}
