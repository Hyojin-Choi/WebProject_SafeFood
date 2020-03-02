package com.ssafy.food.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.food.service.IQnaService;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
public class QnaController {
	@Autowired
	@Qualifier("QnaServiceImpl")
	IQnaService bs;
	

	@RequestMapping("/ann")
	public String Board(HttpServletRequest req, Model model) {
		System.out.println(bs.selectList().toString());
		model.addAttribute("board", bs.selectList());
		return "ann";
	}
}
