package com.util;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> tset = new TreeSet<>();
		tset.add("hello");
		tset.add("123");
		tset.add("하이룽");
		tset.add("쥬뗌므");
		
		System.out.println(tset);
		System.out.println(tset.first());
		System.out.println(tset.last());
		tset.pollFirst();//첫번재꺼 삭제
		tset.pollLast();//마지막꺼 삭제
		System.out.println(tset);
	}

}
