package com.gdut.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gdut.entity.Goods;

public interface GoodsService {

	/*
	 * 
	 * 查询所有商品
	 */
	List<Goods> queryAllGoods();

	/*
	 * 
	 * 查询指定名称商品
	 */
	List<Goods> queryGoodsByName(String goodsName);
	
	/*
	 * 添加商品关注
	 */
	String focusGoods(String customId,String goodsId);


	
}
