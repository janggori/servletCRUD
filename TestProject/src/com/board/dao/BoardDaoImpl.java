package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;
import com.jdbc.DbConnection;


public class BoardDaoImpl implements BoardDao {

	@Override
	public List<BoardDto> boardList(String searchType, String searchText) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		Connection conn = DbConnection.getDbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT B_NO,B_TITLE,B_WRITER, DATE_FORMAT(B_DATE, \"%y-%m-%d\") AS B_DATE, B_CON, B_HITS FROM BOARD WHERE B_DEL ='N' ORDER BY B_NO DESC";
			pstmt = conn.prepareStatement(sql);		
			if((searchType != null)&&(searchText !=null)) {
				if(searchType.equals("0")) {
					sql = "SELECT B_NO,B_TITLE,B_WRITER, DATE_FORMAT(B_DATE, \"%y-%m-%d\") AS B_DATE, B_CON, B_HITS FROM BOARD WHERE B_DEL ='N' AND (B_TITLE LIKE CONCAT('%', ? ,'%') OR B_WRITER LIKE CONCAT('%',?,'%')) ORDER BY B_NO DESC";					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, searchText);
					pstmt.setString(2, searchText);
				} else if(searchType.equals("1")) {
					sql = "SELECT B_NO,B_TITLE,B_WRITER, DATE_FORMAT(B_DATE, \"%y-%m-%d\") AS B_DATE, B_CON, B_HITS FROM BOARD WHERE B_DEL ='N' AND B_TITLE LIKE CONCAT('%',?,'%') ORDER BY B_NO DESC";					
					pstmt = conn.prepareStatement(sql);		
					pstmt.setString(1, searchText);
				} else if(searchType.equals("2")) {
					sql = "SELECT B_NO,B_TITLE,B_WRITER, DATE_FORMAT(B_DATE, \"%y-%m-%d\") AS B_DATE, B_CON, B_HITS FROM BOARD WHERE B_DEL ='N' AND B_WRITER LIKE CONCAT('%',?,'%') ORDER BY B_NO DESC";										
					pstmt = conn.prepareStatement(sql);		
					pstmt.setString(1, searchText);
				}
			}; 			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String date = rs.getString(4);
				String con = rs.getString(5);
				int hits = rs.getInt(6);
								
				BoardDto dto = new BoardDto(no,title,writer,date,con,hits);
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(rs);
			DbConnection.close(pstmt);
			DbConnection.close(conn);
		}
		return list;
	}

	@Override
	public int insertBoard(String title, String writer, String con) {
		int result = 0;
		Connection conn = DbConnection.getDbConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO BOARD (B_NO,B_TITLE, B_WRITER, B_CON)  VALUES ((SELECT MAX(B_NO) +1 FROM BOARD B),?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, con);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			DbConnection.close(pstmt);
			DbConnection.close(conn);
		}
		
		return result;
	}

	@Override
	public BoardDto selectOne(int no) {
		BoardDto dto = null;
		Connection conn = DbConnection.getDbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT B_TITLE,B_WRITER, DATE_FORMAT(B_DATE, \"%y-%m-%d\") AS B_DATE, B_CON, B_HITS FROM BOARD WHERE B_DEL ='N' AND B_NO = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			String title = rs.getString(1);
			String writer = rs.getString(2);
			String date = rs.getString(3);
			String con = rs.getString(4);
			int hits = rs.getInt(5);
			
			dto = new BoardDto(no, title, writer, date, con, hits);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(rs);
			DbConnection.close(pstmt);
			DbConnection.close(conn);
		}
		return dto;
	}

	@Override
	public int updateBoard(int no, String title, String writer, String con) {
		int result = 0;
		Connection conn = DbConnection.getDbConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE BOARD SET B_TITLE = ? , B_WRITER=?, B_CON =? WHERE B_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, con);
			pstmt.setInt(4, no);			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(pstmt);
			DbConnection.close(conn);
		}
		return result;
	}

	@Override
	public int delectBoard(int no) {
		int result = 0;
		Connection conn = DbConnection.getDbConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM BOARD WHERE B_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(pstmt);
			DbConnection.close(conn);
		}
		return result;
	}

	@Override
	public int viewCntUp(int no) {
		int result = 0;
		Connection conn = DbConnection.getDbConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE BOARD SET B_HITS= B_HITS+1 WHERE B_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(pstmt);
			DbConnection.close(conn);
		}
		
		return result;
	}
}
