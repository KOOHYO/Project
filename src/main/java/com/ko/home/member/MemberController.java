package com.ko.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
}