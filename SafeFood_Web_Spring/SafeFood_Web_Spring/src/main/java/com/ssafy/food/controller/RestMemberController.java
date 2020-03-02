package com.ssafy.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.food.dto.MemVO;
import com.ssafy.food.service.IMemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestMemberController {
	@Autowired
	private IMemberService ser;
	
	@ApiOperation(value="맴버를 등록합니다.")
	@PostMapping(value = "/SignUp")
	public ResponseEntity<String> insert(@RequestBody MemVO mem) {
		ResponseEntity<String> re = null;
		try {
			System.out.println("dkdkdkdkdk");
			System.out.println(mem.toString());
			ser.addMem(mem.getId(), mem.getPw(), mem.getName(), mem.getAddr(), mem.getEmail(), mem.getTel(), mem.getAlinfo());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
			System.out.println("들어왓니 ?");
		} catch (Exception e) {
			//HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value="맴버를 삭제합니다.")
	@DeleteMapping(value = "/Delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		ResponseEntity<String> re = null;
		try {
			ser.delMem(id);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="비밀번호를 찾습니다.")
	@GetMapping(value = "/searchpw")
	public ResponseEntity<String> searchpw(MemVO mem) {
		ResponseEntity<String> re = null;
		try {
			String pw = ser.searchpw(mem.getId(), mem.getName());
			re = new ResponseEntity<String>(pw, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("비밀번호 찾기에 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="맴버를 id로 조회합니다.")
	@GetMapping(value = "/memInfo/{id}")
	public ResponseEntity<MemVO> selectOne(@PathVariable String id) {
		ResponseEntity<MemVO> re = null;
		try {
			MemVO selectOne = ser.memInfo(id);
			re = new ResponseEntity<MemVO>(selectOne, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="맴버를 수정합니다.")
	@PutMapping(value = "/Update")
	public ResponseEntity<String> update(MemVO mem) {
		ResponseEntity<String> re = null;
		try {
			ser.updateMem(mem.getId(), mem.getPw(), mem.getName(), mem.getAddr(), mem.getEmail(), mem.getTel(), mem.getAlinfo());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}
	
	
	//로그인 로그아웃?	
	@ApiOperation(value="로그인 처리")
	@GetMapping("/Login/{id}&{pw}")
	public boolean Login(@PathVariable String id, @PathVariable String pw) {
		System.out.println(id+", "+pw);
		return ser.isLogin(id, pw);
	}
	
	@ApiOperation(value="로그아웃 처리")
	@GetMapping("/Logout")
	public ModelAndView Logout(HttpServletRequest req, ModelAndView mv, HttpSession ss) {
		ss.invalidate();
		mv.setViewName("redirect:main");
		return mv;
	}
}
