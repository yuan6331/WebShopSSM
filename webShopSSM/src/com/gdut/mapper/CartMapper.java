package com.gdut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdut.entity.Cart;

public interface CartMapper {
	Cart queryGoodsFromCart(@Param(value = "customId") String customId, @Param(value = "goodsId") String goodsId);

	List<Cart> queryCart(@Param(value = "customId") String customId);

	void addToCart(@Param(value = "customId") String customId, @Param(value = "goodsId") String goodsId,
			@Param(value = "goodsNumber") int goodsNumber);

	void deleteGoodsFromCart(@Param(value = "customId") String customId, @Param(value = "goodsId") String goodsId);

	void deleteCart(@Param(value = "customId") String customId);

	void updetaCart(@Param(value = "customId") String customId, @Param(value = "goodsId") String goodsId,
			@Param(value = "goodsNumber") int goodsNumber);

}
