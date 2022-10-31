package com.ko.home.board.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class QnaController {

	@GetMapping("list")
	public String getList()throws Exception{
		return "board/list";
	}
	
}
