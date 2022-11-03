package com.ko.home.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MemberServiceTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//@Test
	void test() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("hyo");
		memberVO.setPw("hyo");
		memberVO.setName("효");
		memberVO.setEmail("hyo@gmail.com");
		
	}

}
