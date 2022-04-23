package com.bms.cart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.cart.dto.CartDto;
import com.bms.goods.dto.GoodsDto;
import com.bms.goods.dto.ImageFileDto;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CartDto> getGoodsIdList(String userid) {	
		return sqlSession.selectList("mapper.cart.goodsIdList", userid);
	}

	@Override
	public List<GoodsDto> getMyCartList(List<CartDto> cartlist) {
		return sqlSession.selectList("mapper.cart.goodsInfoList", cartlist);
	}
	
	@Override
	public List<ImageFileDto> getGoodsImageList(List<CartDto> cartlist) {
		return sqlSession.selectList("mapper.cart.goodsImageInfoList", cartlist);
	}
	
	@Override
	public void addGoodsInCart(CartDto cartDto) throws Exception{
		
		sqlSession.insert("mapper.cart.addGoodsInCart" , cartDto);
	}
	
	@Override
	public boolean overlapGoodsChk(CartDto cartDto) throws Exception{
		
		boolean goodsChk = false;
		
		if(sqlSession.selectOne("mapper.cart.overlapGoodsChk" , cartDto) == null) {
			goodsChk = true;
			return goodsChk;
		} 
		return goodsChk;
	}
	
	@Override
	public void deleteCartGoods(int goodsId) throws Exception{
		sqlSession.delete("mapper.cart.deleteCartGoods" , goodsId);
	}
}
