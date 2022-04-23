package com.bms.cart.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bms.cart.dto.CartDto;
import com.bms.cart.service.CartService;
import com.bms.member.dto.MemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;

	
	@RequestMapping(value="/cartMain.do/{userid}" , method = RequestMethod.GET)
	public String cartMain(@PathVariable("userid") String memberId, Model model) throws Exception {
		
		Map<String, List> cartMap = cartService.selectCartList(memberId);
		
		model.addAttribute("cartMap", cartMap);

		return "/cart/cartMain";
	}
	
	@RequestMapping(value="/addGoodsInCart.do" , method = RequestMethod.POST)
	public ResponseEntity<String> addGoodsInCart(@RequestParam Map<String, Object> goodsInfo ,HttpServletRequest request) throws Exception {
		 			
		ObjectMapper mapper = new ObjectMapper();
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		goodsInfo.put("memberId", memberInfo.getMemberId());
		String message;
		
		CartDto cDto = mapper.convertValue(goodsInfo ,CartDto.class);
		if(cartService.addGoodsInCart(cDto)) {
			   message  = "<script>";
			   message += " alert('상품을 담았습니다.');";
			   message += " location.href='" + request.getContextPath() + "/main/main.do';";
			   message += " </script>";
		} else {
			   message  = "<script>";
			   message += " alert('이미 등록된 상품입니다.');";
			   message += " location.href='" + request.getContextPath() + "/main/main.do';";
			   message += " </script>";
		}

		   HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		   return new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/deleteCartGoods.do" , method = RequestMethod.POST)
	@ResponseBody
	public String deleteCartGoods(@RequestParam("id") int goodsId) throws Exception {
		cartService.deleteCartGoods(goodsId);
		return "success";
		

	}
	
}
