package com.util;

import java.util.HashMap;
import java.util.Set;
//Map : key - value 쌍(entry)로 저장되는 구조. 키 중복 안됨, 순서 상관 없음
public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<>();
		map.put("num", "12345");
		map.put("name", "tomes");
		map.put("address", "london");
		map.put("address", "paris"); //키는 중복되면 안되지만 컴파이 에러는 나지 않는다. 
		
		String val1 = map.get("num");
		String val2 = map.get("address");
//		System.out.println(val1 + "--" + val2);
		
		Set<String> keys = map.keySet();//map안의 키만 추출됨
		for(String key:keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
