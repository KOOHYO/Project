package com.ko.home.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String getLogin()throws Exception{
		return "member/login";
	}
	
	@GetMapping("join")
	public String setAdd(@ModelAttribute MemberVO memberVO)throws Exception{
		return "member/join";
	}
	
	@PostMapping("join")
	public String setAdd(@Valid MemberVO memberVO, BindingResult bindingResult)throws Exception{
		int result = memberService.setAdd(memberVO);
		return "member/join";
	}
	
}
