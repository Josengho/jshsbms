package com.bms.cart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.cart.dao.CartDao;
import com.bms.cart.dto.CartDto;
import com.bms.goods.dto.GoodsDto;


@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public Map<String, List> selectCartList(String memberId) throws Exception{
		
		Map<String, List> cartMap = new HashMap<String, List>();
		
		List<CartDto> cartList = cartDao.getGoodsIdList(memberId);
		if (cartList.size() == 0) {
			return null;
		}
		
		List<GoodsDto> goodsList = cartDao.getMyCartList(cartList);
		
		cartMap.put("cartList", cartList);
		cartMap.put("goodsList", goodsList);
		
		return cartMap;
	}
	
	@Override
	public void addGoodsInCart(CartDto cartDto) throws Exception{
		
		cartDao.addGoodsInCart(cartDto);
	}


}
