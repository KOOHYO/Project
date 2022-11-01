package com.ko.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ko.home.util.Pager;

@Mapper
public interface QnaMapper {

	public List<QnaVO> getList(Pager pager)throws Exception;
	
}
