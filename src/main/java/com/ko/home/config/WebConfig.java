package com.ko.home.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

	//실행할때 객체가 만들어짐
	@Value("${app.upload.base}")//spEl
	private String filePath;
	
	@Value("${app.url.path}")
	private String urlPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		log.info("========================================");
		log.info("** FilePath ** {} ", filePath);
		log.info("** UrlPath ** {} ", filePath);
		log.info("========================================");
		
		//스프링 레거시 에서 이 역할을 함
		//<resources mapping="/resources/**" location="/resources/" />
		registry.addResourceHandler(urlPath) // 요청 URL 주소
				.addResourceLocations(filePath); // 보여줄때는 이 경로를 따라가야함, 다운로드는 다른경로
	}
	
}
