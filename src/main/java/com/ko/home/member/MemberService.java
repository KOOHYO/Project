package com.ko.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public int setAdd(MemberVO memberVO)throws Exception{
		return memberMapper.setAdd(memberVO);
	}
	
}
