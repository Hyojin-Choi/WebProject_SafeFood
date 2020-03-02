package com.ssafy.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.food.dto.QnaDto;

@Repository(value = "QnaDaoImpl")
public class QnaDaoImpl implements IQnaDao{

	@Autowired
	private SqlSession ss;
	
	@Override
	public void insert(QnaDto d) {
		// TODO Auto-generated method stub
		ss.insert("qna.insertqna", d);
	}

	@Override
	public void update(QnaDto d) {
		// TODO Auto-generated method stub
		ss.update("qna.updateqna", d);

	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		ss.delete("qna.deleteqna", num);
	}

	@Override
	public QnaDto selectOne(int num) {
		// TODO Auto-generated method stub
		return ss.selectOne("qna.selectone", num);	
	}

	@Override
	public List<QnaDto> selectList() {
		// TODO Auto-generated method stub
		return ss.selectList("qna.selectlist");
	}

}
