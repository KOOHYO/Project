package com.ko.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ko.home.util.Pager;

@SpringBootTest
class QnaServiceTest {

	@Autowired
	private QnaMapper qnaMapper;
	
	//@Test
	void getList() throws Exception {
		Pager pager = new Pager();
		QnaVO qnaVO = new QnaVO();
		List<QnaVO> qnaVOs = qnaMapper.getTextList(pager);
		assertNotEquals(0, qnaVOs.size());
	}

}
