package com.ssafy.food.dao;

import java.util.List;

import com.ssafy.food.dto.QnaDto;

public interface IQnaDao{
	public void insert(QnaDto d);
	public void update(QnaDto d);
	public void delete(int num);
	public QnaDto selectOne(int num);
	public List<QnaDto> selectList();
}
