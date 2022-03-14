package com.bms.mypage.dao;

import java.util.List;
import java.util.Map;

import com.bms.member.dto.MemberDto;
import com.bms.order.dto.OrderDto;

public interface MyPageDao {
	
	public List<OrderDto> selectMyOrderGoodsList(String memberId) throws Exception;
	public Map<String,Object> selectMyOrderInfo(String orderId) throws Exception;
	public List<OrderDto> selectMyOrderHistoryList(Map<String,String> dateMap) throws Exception;
	public void updateMyInfo(Map<String,String> memberMap) throws Exception;
	public MemberDto selectMyDetailInfo(String memberId) throws Exception;
	public void updateMyOrderCancel(String orderId) throws Exception;

}
