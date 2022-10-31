package com.ko.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaServiceTest {

	@Autowired
	private QnaMapper qnaMapper;
	
	//@Test
	void getList() throws Exception {
		QnaVO qnaVO = new QnaVO();
		List<QnaVO> qnaVOs = qnaMapper.getList();
		assertNotEquals(0, qnaVOs.size());
	}

}
