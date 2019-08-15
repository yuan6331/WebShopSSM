package com.gdut.entity;

public class Custom {
	private String customId;
	private String customPwd;
	private String customName;
	private int customSex;
	private String customPhoneNum;
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	public String getcustomPwd() {
		return customPwd;
	}
	public void setcustomPwd(String customPwd) {
		this.customPwd = customPwd;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public int getCustomSex() {
		return customSex;
	}
	public void setCustomSex(int customSex) {
		this.customSex = customSex;
	}
	public String getCustomPhoneNum() {
		return customPhoneNum;
	}
	public void setCustomPhoneNum(String customPhoneNum) {
		this.customPhoneNum = customPhoneNum;
	}
	@Override
	public String toString() {
		return "Custom [customId=" + customId + ", customPwd=" + customPwd + ", customName=" + customName
				+ ", customSex=" + customSex + ", customPhoneNum=" + customPhoneNum + "]";
	}
	public Custom(String customId, String customPwd, String customName, int customSex, String customPhoneNum) {
		super();
		this.customId = customId;
		this.customPwd = customPwd;
		this.customName = customName;
		this.customSex = customSex;
		this.customPhoneNum = customPhoneNum;
	}
	public Custom() {
		super();
	}
	
	
	
}
