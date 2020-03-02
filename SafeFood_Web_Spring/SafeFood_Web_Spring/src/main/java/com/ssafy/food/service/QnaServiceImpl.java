package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.IQnaDao;
import com.ssafy.food.dto.QnaDto;

@Service("QnaServiceImpl")
public class QnaServiceImpl implements IQnaService{

	@Autowired
	@Qualifier("QnaDaoImpl")
	private IQnaDao ser;

	public QnaServiceImpl() {
	}
	
	@Override
	public void insert(int num, String title, String memo, String id) {
		// TODO Auto-generated method stub
		ser.insert(new QnaDto(num, title, memo, id));
	}

	@Override
	public void update(int num, String title, String memo, String id) {
		// TODO Auto-generated method stub
		ser.update(new QnaDto(num, title, memo, id));
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		ser.delete(num);
	}

	@Override
	public QnaDto selectOne(int num) {
		// TODO Auto-generated method stub
		return ser.selectOne(num);
	}

	@Override
	public List<QnaDto> selectList() {
		// TODO Auto-generated method stub
		return ser.selectList();
	}

}
