package com.ko.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public ModelAndView getList()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> qnaVOs = qnaService.getList();
		
		mv.addObject("qnaVOs", qnaVOs);
		mv.setViewName("board/list");
		return mv;
	}
	
}
