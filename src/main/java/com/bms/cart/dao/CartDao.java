package com.bms.cart.dao;

import java.util.List;

import com.bms.cart.dto.CartDto;
import com.bms.goods.dto.GoodsDto;

public interface CartDao {

	public List<CartDto> getGoodsIdList(String userid) throws Exception;
	
	public List<GoodsDto> getMyCartList(List<CartDto> cartlist) throws Exception;

	public void addGoodsInCart(CartDto cartDto) throws Exception;

}
