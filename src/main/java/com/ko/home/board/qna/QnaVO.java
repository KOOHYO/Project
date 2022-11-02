package com.ko.home.board.qna;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class QnaVO {

	private Long num;
	@NotBlank(message = "제목을 입력하세요")
	private String title;
	@NotBlank(message = "작성자명은 필수입니다!")
	private String writer;
	@NotBlank(message = "내용을 입력하세요")
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	
	private MultipartFile [] files;
	private List<QnaFileVO> qnaFileVOs;
	
}
