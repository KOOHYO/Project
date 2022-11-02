package com.ko.home.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		QnaFileVO qnaFileVO = new QnaFileVO();
		qnaVO = qnaService.getDetail(qnaVO);
//		for(QnaFileVO f :qnaVO.getQnaFileVOs()) {
//			qnaFileVO.setFileName(f.getFileName());
//			qnaFileVO.setFileNum();
//		}
		mv.addObject("vo", qnaVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("add")
	public String setAddText(@ModelAttribute QnaVO qnaVO)throws Exception{
		
		return "board/write";
	}
	
	@PostMapping("add")
	public ModelAndView setAddText(@Valid QnaVO qnaVO, BindingResult bindingResult)throws Exception{
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			log.info("------------------ 검증에러 발생 ------------------");
			mv.setViewName("board/write");
			return mv;
		}
		
		log.info("------------------ 검증 ------------------");
		int result = qnaService.setAddText(qnaVO);
		mv.setViewName("board/list");
		
		return mv;
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
