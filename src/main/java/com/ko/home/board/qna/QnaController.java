package com.ko.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("add")
	public String setAddText()throws Exception{
		
		return "board/write";
	}
	
	@PostMapping("add")
	public String setAddText(QnaVO qnaVO)throws Exception{
		int result = qnaService.setAddText(qnaVO);
		if(result > 0) {
			return "redirect:../qna/list";
		}
		return "board/write";
	}
	
	@GetMapping("list")
	public ModelAndView getTextList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> qnaVOs = qnaService.getList(pager);
		
		mv.addObject("qnaVOs", qnaVOs);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}
	
}
