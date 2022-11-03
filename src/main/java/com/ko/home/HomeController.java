package com.ko.home;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String home(HttpSession session)throws Exception{
		log.info("---------------");
		Enumeration<String> en = session.getAttributeNames();
		
		// hasMoreElements() : Elements가 있습니까?
		while(en.hasMoreElements()) {
			// nextElement() : 있으면 주세요
			String key = en.nextElement();
			// SPRING_SECURITY_CONTEXT 란 키가 나옴
			log.info("Key => {} ", key);
		}
		
		// SecurityContextImpl 클래스가 있다
		// SecurityContext 타입을 구현한 SecurityContext 타입의 SecurityContextImpl 클래스이기 때문에
		// SecurityContext 를 써도 무방하다
		SecurityContextImpl context = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		log.info("Obj => {} ", context);

		return "index";
	}
}
