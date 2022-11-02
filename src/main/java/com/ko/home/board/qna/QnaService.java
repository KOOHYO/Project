package com.ko.home.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ko.home.util.FileManager;
import com.ko.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	// properties파일의 내용을 java에서 사용
	@Value("${app3.upload.qna}")
	private String path;
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception{
		return qnaMapper.getDetail(qnaVO);
	}
	
	public int setAddText(QnaVO qnaVO)throws Exception{
		// 글 작성 먼저!
		int result = qnaMapper.setAddText(qnaVO);
		
		// 파일 객체 생성
		File file = new File(path);
		
		// 만약 파일이 없다면 폴더를 생성
		if(!file.exists()) {
			// 중간 폴더가 없으면 중간 폴더도 생성
			boolean check = file.mkdirs();
		}
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("FileName {} ", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setNum(qnaVO.getNum());
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setAddFile(qnaFileVO);
			}
		}
		
		return result;
	}
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		Long totalCount = qnaMapper.getTextCount(pager);
		pager.getNum(totalCount);
		pager.makeRow();
		return qnaMapper.getTextList(pager);
	}
	
}
