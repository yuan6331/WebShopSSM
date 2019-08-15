package com.gdut.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.gdut.entity.Cart;

public interface CartService {
	
//	Cart queryGoodsFromCart(String customId, String goodsId);
		
	String queryCart(HttpServletRequest request,String customId,Model model);
	
	String addToCart(HttpServletRequest request,HttpServletResponse response,String goodsId,int goodsNumber);

	void deleteGoodsFromCart(String customId, String goodsId);

	void deleteCart(String customId);
	
	void settlement();
	
	void updetaCart(String customId,String goodsId, int goodsNumber);

}
