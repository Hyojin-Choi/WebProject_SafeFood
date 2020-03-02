package com.ssafy.food.service;

import java.util.List;

import com.ssafy.food.dto.BoardDto;

public interface IBoardService {

	public void insert(int num, String name, String title,String memo,String date, int cnt);
	public void update(int num, String name, String title,String memo,String date, int cnt);
	public void delete(int num);
	public BoardDto selectOne(int num);
	public List<BoardDto> selectList();
}
