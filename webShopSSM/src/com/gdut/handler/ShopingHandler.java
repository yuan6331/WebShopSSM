package com.gdut.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdut.service.impl.CartServiceImpl;
import com.gdut.service.impl.LoginServiceImpl;

@Controller
@RequestMapping(value = "afterLogin")
public class ShopingHandler {

	// @Autowired
	// GoodsServiceImpl goodsService;
	//
	@Autowired
	LoginServiceImpl loginService;

	@Autowired
	CartServiceImpl cartService;

	@RequestMapping(value = "addToCart", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String addToCart(HttpServletRequest request, HttpServletResponse response, String customId, String goodsId,
			@RequestParam(defaultValue = "1") int goodsNumber) {
		return cartService.addToCart(request, response, goodsId, goodsNumber);
	}
	
	@RequestMapping(value="checkMyCart")
	public String checkMyCart(Model model,HttpServletRequest request,String customId){
		return cartService.queryCart(request, customId, model);
	}

}
