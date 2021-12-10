package com.board.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;
import com.jdbc.DbConnection;


public class BoardDaoImpl implements BoardDao {

	@Override
	public List<BoardDto> boardList() {
		List<BoardDto> dto = new ArrayList<BoardDto>();
		
		Connection conn = DbConnection.getDbConnection();
		return dto;
	}

	@Override
	public int insertBoard(String title, String writer, String con) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDto selectOne(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(int no, String title, String writer, String con) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delectBoard(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
