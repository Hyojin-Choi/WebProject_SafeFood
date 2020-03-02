package com.ssafy.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.food.dto.BoardDto;

@Repository(value = "BoardDaoImpl")
public class BoardDaoImpl implements IBoardDao{

	@Autowired
	private SqlSession ss;
	
	@Override
	public void insert(BoardDto d) {
		// TODO Auto-generated method stub
		ss.insert("board.insertb", d);
	}

	@Override
	public void update(BoardDto d) {
		// TODO Auto-generated method stub
		ss.update("board.updateb", d);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		ss.delete("board.deleteb", num);
	}

	@Override
	public BoardDto selectOne(int num) {
		// TODO Auto-generated method stub
		return ss.selectOne("board.selectone",num);
	}

	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return ss.selectList("board.selectlist");
	}

}
