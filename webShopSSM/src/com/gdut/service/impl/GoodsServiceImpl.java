package com.gdut.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdut.entity.Goods;
import com.gdut.mapper.GoodsMapper;
import com.gdut.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper goodsMapper;

	@Override
	public List<Goods> queryAllGoods() {
		return goodsMapper.queryAllGoods();
	}

	@Override
	public List<Goods> queryGoodsByName(String goodsName) {
		return goodsMapper.queryGoodsByName(goodsName);
	}

	@Override
	public String focusGoods(String customId, String goodsId) {
		// TODO Auto-generated method stub
		return null;
	}

}
