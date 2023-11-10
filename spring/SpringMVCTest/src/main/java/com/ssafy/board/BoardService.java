package com.ssafy.board;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

//client(BoardApp.java)를 위한 인터페이스
public interface BoardService {
	public List<Board> selectAll();
	public Board selectOne(String num);
	public void insert(Board c);//번호 기준으로 제목과 내용 수정
	public void delete(String num);
	public void update(Board b);
	public List<Board> findByTitle(String title);
	public List<Board> findByName(String name);
	
	public List<Board> findByTitle2(String title);//like 검색
	@Transactional
	public void delete2(String[] nums);//여러개의 글 한꺼번에 삭제
	
}
