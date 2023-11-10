package com.dao;

import java.util.List;

import com.domain.Board;

public interface IBoard {
	public List<Board> selectAll(); //목록화면에서 모든 글 검색
	public Board selectOne(String num); //글읽기화면에서 해당 글 검색
	public int insert(Board b); //새글등록
	public int delete(String num); //글 삭제
	public List<Board> search(String condition, String word); //검색 (검색조건:이름, 제목|검색내용)
	
}
