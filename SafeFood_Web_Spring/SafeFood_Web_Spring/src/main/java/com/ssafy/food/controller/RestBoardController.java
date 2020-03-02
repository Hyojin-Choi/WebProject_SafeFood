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

import com.ssafy.food.dto.BoardDto;
import com.ssafy.food.dto.QnaDto;
import com.ssafy.food.service.IBoardService;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestBoardController {
	@Autowired
	@Qualifier("BoardServiceImpl")
	private IBoardService ser;
	
	@PostMapping("/boardinsert")
	public ResponseEntity<String> insert(@RequestBody BoardDto b) {
		ResponseEntity<String> re = null;
		try {
			//System.out.println("들어와따!");
			//System.out.println(b.getNum()+ b.getName()+ b.getTitle()+b.getMemo()+ b.getCnt());
			ser.insert(b.getNum(), b.getName(), b.getTitle(),b.getMemo(), b.getDate(),b.getCnt());
			re = new ResponseEntity<String>("게시물 작성 성공", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("게시물 작성 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}	
	
	@PutMapping("/boardupdate")
	public ResponseEntity<String> update(@RequestBody BoardDto b){
		ResponseEntity<String> re = null;
		try {
			ser.update(b.getNum(), b.getName(), b.getTitle(), b.getMemo(),b.getDate(),b.getCnt());
			re = new ResponseEntity<String>("게시물 수정  성공", HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity<String>("게시물 수정 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@DeleteMapping("/boarddelete/{num}")
	public ResponseEntity<String> delete(@PathVariable int num){
		System.out.println(num);
		ResponseEntity<String> re = null;
		try {
			System.out.println("삭제삭제");
			ser.delete(num);
			re = new ResponseEntity<String>("게시물 삭제 성공", HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity<String>("게시물 삭제 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}
	
	@GetMapping("/boardselectone/{num}")
	public ResponseEntity<BoardDto> selectOne(@PathVariable int num){
		ResponseEntity<BoardDto> re = null;
		try {
			BoardDto b = ser.selectOne(num);
			re = new ResponseEntity<BoardDto>(b, HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity("게시물 조회 실패", HttpStatus.NO_CONTENT);
		}
		return re;
	}
	
	@GetMapping("/boardselectall")
	public ResponseEntity<List<BoardDto>> selectAll(){
		//System.out.println("요깅");
		ResponseEntity<List<BoardDto>> re = null;
		try {
			List<BoardDto> list = ser.selectList();
			System.out.println(list.get(0).toString());
			re = new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity("게시물 조회 실패", HttpStatus.NO_CONTENT);
		}
		return re;
	}
}
