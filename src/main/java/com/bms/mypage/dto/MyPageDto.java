package com.bms.mypage.dto;

import org.springframework.stereotype.Component;

@Component
public class MyPageDto {
	
	// 마이페이지 주문 내역에 관한 정보
	
	// 주문자의 아이디
	private String memberId;
	// 주문 내역 검색에 필요한 시작 날짜
	private String beginDate;
	// 주문 내역 검색에 필요한 마지막 날짜
	private String endDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
