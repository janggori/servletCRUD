package com.board.dto;

public class BoardDto {
	private int b_no;
	private String b_title;
	private String b_writer;
	private String b_date;
	private String b_con;
	private int b_hits;
	
	public BoardDto() {
		super();
	}

	public BoardDto(int b_no, String b_title, String b_writer, String b_date, String b_con, int b_hits) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_date = b_date;
		this.b_con = b_con;
		this.b_hits = b_hits;
	}
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_con() {
		return b_con;
	}
	public void setB_con(String b_con) {
		this.b_con = b_con;
	}
	public int getB_hits() {
		return b_hits;
	}
	public void setB_hits(int b_hits) {
		this.b_hits = b_hits;
	}	
}
