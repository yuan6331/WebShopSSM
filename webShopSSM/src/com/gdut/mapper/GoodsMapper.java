package com.gdut.mapper;

import java.util.List;

import com.gdut.entity.Goods;

public interface GoodsMapper {

	List<Goods> queryAllGoods();
	
	List<Goods> queryGoodsByName(String goodsName);
	
	
}
