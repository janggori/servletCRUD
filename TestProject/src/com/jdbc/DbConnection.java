package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnection {
	
	public static Connection getDbConnection() {
		Connection conn = null;
		
		try {
			InitialContext initCtx = new InitialContext();
			
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost/mydb?serverTimezone=UTC";
//			String id = "user";
//			String pw = "123412341234";
			
//			conn = DriverManager.getConnection(url, id, pw);
			
		} 
//		catch (ClassNotFoundException e) {
//			 e.printStackTrace();
//		} 
		catch (SQLException e) {
			 e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();				
			} catch (SQLException e) {
				 e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
