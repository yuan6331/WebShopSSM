package com.gdut.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	String login(String customId,String customPwd);
	
	String loginOff(HttpServletRequest request);
	
}
