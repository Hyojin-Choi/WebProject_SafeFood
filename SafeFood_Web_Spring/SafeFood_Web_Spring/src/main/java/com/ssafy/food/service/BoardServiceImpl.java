package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.IBoardDao;
import com.ssafy.food.dto.BoardDto;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements IBoardService{

	@Autowired
	@Qualifier("BoardDaoImpl")
	private IBoardDao ser;
	
	@Override
	public void insert(int num, String name, String title,String memo, String date,int cnt) {
		// TODO Auto-generated method stub
		ser.insert(new BoardDto(num, name, title, memo,date, cnt));
	}

	@Override
	public void update(int num, String name, String title, String memo,String date,int cnt) {
		// TODO Auto-generated method stub
		ser.update(new BoardDto(num, name, title, memo,date,cnt));

	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		ser.delete(num);

	}

	@Override
	public BoardDto selectOne(int num) {
		// TODO Auto-generated method stub
		return ser.selectOne(num);
	}

	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return ser.selectList();
	}

}
