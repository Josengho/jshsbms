package com.bms.cart.service;

import java.util.List;
import java.util.Map;

import com.bms.cart.dto.CartDto;


public interface CartService {
	
	public Map<String, List> selectCartList(String memberId) throws Exception;
	
	public boolean addGoodsInCart(CartDto cartDto) throws Exception;

	public void deleteCartGoods(int goodsId) throws Exception;
	

}
