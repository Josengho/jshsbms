package com.bms.cart.dao;

import java.util.List;
import java.util.Map;

import com.bms.cart.dto.CartDto;
import com.bms.goods.dto.GoodsDto;
import com.bms.goods.dto.ImageFileDto;

public interface CartDao {

	public List<CartDto> getGoodsIdList(String userid) throws Exception;
	
	public List<GoodsDto> getMyCartList(List<CartDto> cartlist) throws Exception;

	public void addGoodsInCart(CartDto cartDto) throws Exception;

	public boolean overlapGoodsChk(CartDto cartDto) throws Exception;

	public List<ImageFileDto> getGoodsImageList(List<CartDto> cartlist) throws Exception;

	public void deleteCartGoods(int goodsId) throws Exception;

}
