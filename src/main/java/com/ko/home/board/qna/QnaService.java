package com.ko.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ko.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		Long totalCount = qnaMapper.getTextCount(pager);
		pager.getNum(totalCount);
		pager.makeRow();
		return qnaMapper.getTextList(pager);
	}
	
	public int setAddText(QnaVO qnaVO)throws Exception{
		return qnaMapper.setAddText(qnaVO);
	}
	
}
