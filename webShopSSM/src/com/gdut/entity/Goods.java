package com.gdut.entity;

public class Goods {
	private long goodsId;
	private String goodsName;
	private double goodsPrice;
	private String goodsDetail;
	private String goodsNum;
	private String goodsImg;

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsDetail=" + goodsDetail + ", goodsNum=" + goodsNum + ", goodsImg=" + goodsImg + "]";
	}

	public Goods(long goodsId, String goodsName, double goodsPrice, String goodsDetail, String goodsNum,
			String goodsImg) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsDetail = goodsDetail;
		this.goodsNum = goodsNum;
		this.goodsImg = goodsImg;
	}

	public Goods() {
		super();
	}

}
