package com.ssafy.food.service;

import java.util.List;

import com.ssafy.food.dto.QnaDto;


public interface IQnaService {
	public void insert(int num, String title, String memo, String id);
	public void update(int num, String title, String memo, String id);
	public void delete(int num);
	public QnaDto selectOne(int num);
	public List<QnaDto> selectList();
}
