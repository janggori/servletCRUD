package com.board.dao;

import java.util.List;

import com.board.dto.BoardDto;

public interface BoardDao {
	public List<BoardDto> boardList();
	
	public int insertBoard(String title, String writer, String con);
	
	public BoardDto selectOne(int no);
	
	public int updateBoard(int no, String title, String writer, String con);
	
	public int delectBoard(int no);
}
