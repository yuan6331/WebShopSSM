package com.gdut.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gdut.entity.Goods;

public interface GoodsService {

	/*
	 * 
	 * ��ѯ������Ʒ
	 */
	List<Goods> queryAllGoods();

	/*
	 * 
	 * ��ѯָ��������Ʒ
	 */
	List<Goods> queryGoodsByName(String goodsName);
	
	/*
	 * �����Ʒ��ע
	 */
	String focusGoods(String customId,String goodsId);


	
}
