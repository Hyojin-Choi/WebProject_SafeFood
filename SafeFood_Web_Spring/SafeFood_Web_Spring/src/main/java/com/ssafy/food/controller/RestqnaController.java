package com.ssafy.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.food.dto.QnaDto;
import com.ssafy.food.service.IQnaService;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestqnaController {
	@Autowired
	@Qualifier("QnaServiceImpl")
	private IQnaService bs;

	
	@PostMapping("/qnainsert")
	public ResponseEntity<String> insert(@RequestBody QnaDto b) {
		ResponseEntity<String> re = null;
		try {
			bs.insert(b.getNum(), b.getId(), b.getMemo(), b.getTitle());
			re = new ResponseEntity<String>("게시물 작성 성공", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("게시물 작성 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}
	
	@PutMapping("/qnaupdate")
	public ResponseEntity<String> update(@RequestBody QnaDto b){
		ResponseEntity<String> re = null;
		try {
			bs.update(b.getNum(), b.getId(), b.getMemo(), b.getTitle());
			re = new ResponseEntity<String>("게시물 수정  성공", HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity<String>("게시물 수정 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}
	
	@DeleteMapping("/qnadelete/{num}")
	public ResponseEntity<String> delete(@PathVariable int num){
		ResponseEntity<String> re = null;
		try {
			System.out.println("삭제삭제");
			bs.delete(num);
			re = new ResponseEntity<String>("게시물 삭제 성공", HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity<String>("게시물 삭제 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}
	
	@GetMapping("/qnaselectone/{num}")
	public ResponseEntity<QnaDto> selectOne(@PathVariable int num){
		ResponseEntity<QnaDto> re = null;
		try {
			QnaDto b = bs.selectOne(num);
			re = new ResponseEntity<QnaDto>(b, HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity("게시물 조회 실패", HttpStatus.NO_CONTENT);
		}
		return re;
	}
	
	@GetMapping("/qnaselectall")
	public ResponseEntity<List<QnaDto>> selectAll(){
		System.out.println("요깅");
		ResponseEntity<List<QnaDto>> re = null;
		try {
			List<QnaDto> list = bs.selectList();
			re = new ResponseEntity<List<QnaDto>>(list, HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity("게시물 조회 실패", HttpStatus.NO_CONTENT);
		}
		return re;
	}
}
