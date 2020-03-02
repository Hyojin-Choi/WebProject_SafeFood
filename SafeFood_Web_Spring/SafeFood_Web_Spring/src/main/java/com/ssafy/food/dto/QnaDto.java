package com.ssafy.food.dto;

public class QnaDto {
	private int num;
	private String title;
	private String memo;
	private String id;
	
	public QnaDto() {
		super();
	}
	public QnaDto(int num, String title, String memo, String id) {
		super();
		this.num = num;
		this.title = title;
		this.memo = memo;
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "QnaDao [num=" + num + ", title=" + title + ", memo=" + memo + ", id=" + id + "]";
	}
	
	
}
