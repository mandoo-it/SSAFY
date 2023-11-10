package com.model;

import java.util.ArrayList;

//dao가 구현해야하는 메소드 목록
public interface IBookDAO {
	ArrayList<Book> selectAll();//테이블 안의 모든 레코드 검색
	Book selectOne(String isbn);//isbn기준으로 레코드 검색
	int insert(Book c);//새 레코드 추가
	int delete(String isbn);//isbn 기준으로 레코드 삭제
}
