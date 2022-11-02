package com.ko.home.util;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView {

	@Override
		protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			
		}
	
	// HDD에 File 저장
	public String saveFile(MultipartFile files, String path)throws Exception{
		
		// 1. 중복되지 않는 파일명 생성 (UUID, Date)
		String fileName = UUID.randomUUID().toString();
		
		// 2. 확장자 이어붙이기
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		//bf.append("_");
		
		// 2-1 파일명과 확장자 분리
		String ex = files.getOriginalFilename(); // 고양이.jpg
		ex = ex.substring(ex.lastIndexOf(".")); // 뒤에서부터 .을 기준으로 자름
		
		// 3. 파일명에 이어붙임
		bf.append(ex);
		
		// 4. 완성된 파일명.확장자를 fileName에 대입
		fileName = bf.toString(); // StringBuffer는 String이 아님!
		
		// 5. File Save
		// 5-1 파일 객체 생성시 경로와 파일명을 보냄
		File file = new File(path, fileName);
		files.transferTo(file);
		
		log.info("============================");
		log.info("fileName {} ", fileName);
		
		return fileName;
	}
	
}
