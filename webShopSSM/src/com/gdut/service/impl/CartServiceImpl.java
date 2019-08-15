package com.gdut.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdut.entity.Cart;
import com.gdut.mapper.CartMapper;
import com.gdut.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cartMapper;

	@Autowired
	LoginServiceImpl loginService;

	List<Cart> cartList = new ArrayList<>();

	@Override
	public void deleteGoodsFromCart(String customId, String goodsId) {
		cartMapper.deleteGoodsFromCart(customId, goodsId);
	}

	/*
	 * ��չ��ﳵ
	 * 
	 * @see com.gdut.service.CartService#deleteCart(java.lang.String)
	 */
	@Override
	public void deleteCart(String customId) {
		cartMapper.deleteCart(customId);
	}

	@Override
	public String addToCart(HttpServletRequest request, HttpServletResponse response, String goodsId, int goodsNumber) {
		// ��֤�Ƿ��¼������ӹ��ﳵ
		if (loginService.isLogin(request)) {
			try {
				Cart myCart = cartMapper.queryGoodsFromCart(loginService.getCustomId(request), goodsId);
				if (myCart == null) {
					cartMapper.addToCart(loginService.getCustomId(request), goodsId, goodsNumber);
					return "�Ѽ��빺�ﳵ";
				} else {
					cartMapper.updetaCart(loginService.getCustomId(request), goodsId,
							myCart.getGoodsNumber() + goodsNumber);
					return "�Ѽ��빺�ﳵ";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "���빺�ﳵʧ�ܣ����Ժ����ԣ�";
			}
		} else {
			return "isNotLogin";
		}
	}

	/*
	 * �鿴���ﳵ
	 * 
	 * @see com.gdut.service.CartService#queryCart(javax.servlet.http.
	 * HttpServletRequest, java.lang.String, org.springframework.ui.Model)
	 */
	@Override
	public String queryCart(HttpServletRequest request, String customId, Model model) {
		if (loginService.isLogin(request)) {
			List<Cart> myCartList = new ArrayList<>();
			myCartList = cartMapper.queryCart(loginService.getCustomId(request));
			model.addAttribute("myCartList", myCartList);
			return "afterLogin/myCart";
		}
		return "beforeLogin/index";
	}

	/*
	 * ���ﳵ����
	 */
	@Override
	public void settlement() {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public Cart queryGoodsFromCart(String customId, String goodsId)
	 * { return cartMapper.queryGoodsFromCart(customId, goodsId); }
	 */

	@Override
	public void updetaCart(String customId, String goodsId, int goodsNumber) {
		cartMapper.updetaCart(customId, goodsId, goodsNumber);
	}

}
