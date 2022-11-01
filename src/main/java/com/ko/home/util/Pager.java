package com.ko.home.util;

import lombok.Data;

@Data
public class Pager {
	
	// 페이지 장
	private Long page;
	// 한 페이지에 출력할 글의 갯수 : 10개
	private Long perPage=10L;
	// 시작 번호
	private Long startRow;
	
	// 검색어 변수
	private String search;
	
	// 시작번호 만들기
	public void makeRow() {
		this.startRow = (this.getPage()-1)*perPage;
	}
	
	// 페이지번호가 null이거나 0이하이면 1로 넣어준다
	public Long getPage() {
		if(this.page==null || this.page<1) {
			 this.page=1L;
		}
		return this.page;
	}
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	
}
