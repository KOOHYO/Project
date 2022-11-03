package com.ko.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {
	
	public MemberVO getLogin(String username)throws UsernameNotFoundException;
	
	public int setAdd(MemberVO memberVO)throws Exception;

}
