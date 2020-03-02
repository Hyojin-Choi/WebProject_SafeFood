package com.ssafy.food.dao;

import java.util.List;

import com.ssafy.food.dto.BoardDto;

public interface IBoardDao {
	public void insert(BoardDto d);
	public void update(BoardDto d);
	public void delete(int num);
	public BoardDto selectOne(int num);
	public List<BoardDto> selectList();
}
