package com.ko.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ko.home.util.Pager;

@Mapper
public interface QnaMapper {
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception;
	
	public int setAddFile(QnaFileVO qnaFileVO)throws Exception;
	
	public int setAddText(QnaVO qnaVO)throws Exception;
	
	public Long getTextCount(Pager pager)throws Exception;

	public List<QnaVO> getTextList(Pager pager)throws Exception;
		
}
