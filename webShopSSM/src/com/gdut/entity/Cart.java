package com.gdut.entity;

public class Cart {
	private String customId;
	private String goodsId;
	private int goodsNumber;
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	@Override
	public String toString() {
		return "Cart [customId=" + customId + ", goodsId=" + goodsId + ", goodsNumber=" + goodsNumber + "]";
	}
	public Cart(String customId, String goodsId, int goodsNumber) {
		super();
		this.customId = customId;
		this.goodsId = goodsId;
		this.goodsNumber = goodsNumber;
	}
	public Cart() {
		super();
	}
	
	
}
