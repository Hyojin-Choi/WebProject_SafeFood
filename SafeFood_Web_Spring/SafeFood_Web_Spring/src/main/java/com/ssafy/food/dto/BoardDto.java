package com.ssafy.food.dto;

public class BoardDto {
	private int num;
	private String name;
	private String title;
	private String memo;
	private String date;
	private int cnt;

	public BoardDto() {
		super();
	}

	public BoardDto(int num, String name, String title, String memo, String date, int cnt) {
		super();
		this.num = num;
		this.name = name;
		this.title = title;
		this.memo = memo;
		this.date = date;
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", name=" + name + ", title=" + title + ", memo=" + memo + ", cnt=" + cnt + "]";
	}

}
