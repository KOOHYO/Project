package com.ko.home.util;

import lombok.Data;

@Data
public class Pager {
	
	// 페이지 장
	private Long page;
	// 한 페이지에 출력할 글의 갯수
	private Long perPage;
	// 글 갯수 시작 번호
	private Long startRow;
	// 페이징 시작 번호
	private Long startNum;
	// 페이징 끝 번호
	private Long lastNum;
	// 한 페이지에 출력할 번호의 갯수
	private Long perBlock;
	
	// 이전 블럭의 유무-다음블럭이 있으면 true, 없으면 false
	private boolean pre;
	// 다음 블럭의 유무-다음블럭이 있으면 true, 없으면 false
	private boolean next;

	
	// 검색어 변수
	private String search;
	// 콘텐츠 변수
	private String kind;
	
	// 기본생성자로 값 넣어주기
	public Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	// Mapper에서 사용할 시작번호 만들기
	public void makeRow() {
		this.startRow = (this.getPage()-1)*perPage;
	}
	
	// JSP에서 사용할 값 계산
	public void getNum(Long totalCount)throws Exception{
		// 1. 글 총 갯수로 총 페이지수를 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			// 글이 남으면 총 페이지수 하나 더 증가
			totalPage++;
		}
		
		// 1-1. 총 페이지수보다 페이지가 클 경우
		// 		페이지 값으로 넣어줘서 페이지 변수에 대입
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		
		// 2. 총 페이지로 총 번호블럭을 구함 게시판 아랫단 번호쪽
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			// 블록이 남으면 총 블럭수를 하나 더 증가
			totalBlock++;
		}
		
		// 3. page로 curBlock 찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		// 4. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		// 5. curBlock이 마지막 Block일때(totalBlock과 같을 때)
		//	  lastNum을 totalPage수만큼 나오게끔 한다
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
		
		// 6. 이전, 다음 블럭의 유무
		if(curBlock>1) {
			pre=true;
		}
		
		if(curBlock<totalBlock) {
			next=true;
		}
		
	}
	
	// 한 페이지에 출력할 글의 갯수 : 10개
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	
	public Long getPerBlock() {
		if(this.perBlock==null) {
			this.perBlock=5L;
		}
		return perBlock;
	}
	
	// 페이지번호가 null이거나 0이하이면 1을 기본값으로
	public Long getPage() {
		if(this.page==null || this.page<1) {
			 this.page=1L;
		}
		return this.page;
	}
	
	// 모든것을 출력할 수 있게 빈값을 기본값으로
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	
	
	
}
