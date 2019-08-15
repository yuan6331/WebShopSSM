package com.gdut.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdut.entity.Custom;
import com.gdut.mapper.CustomMapper;
import com.gdut.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomMapper customMapper;

	@Autowired
	HttpServletResponse response;

	@Override
	public String login(@RequestParam String customId, @RequestParam String customPwd) {
		if (customId == null || "".equals(customId) || customPwd == null || "".equals(customPwd)) {
			return "账号密码不能为空！";
		}
		Custom custom = customMapper.queryCustom(customId);
		if (custom == null) {
			return "此账号未注册！";
		}
		if (customPwd.equals(custom.getcustomPwd())) {
			String uuid = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("sessionId", uuid);
			cookie.setPath("/");
			response.addCookie(cookie);
			this.keepCustomId(uuid, customId);
			return "right";
		}
		return "密码错误！";
	}

	Map<String, String> sessionMap = new HashMap<>();

	public void keepCustomId(String sessionId, String customId) {
		this.sessionMap.put(sessionId, customId);
	}

	public String getUuid(HttpServletRequest request) {
		String uuid = "abc";
		for (Cookie cookie : request.getCookies()) {
			if ("sessionId".equals(cookie.getName())) {
				uuid = cookie.getValue();
			}
		}
		return uuid;
	}

	/*
	 * 
	 * 获取cookie中已经登录的id
	 */
	public String getCustomId(HttpServletRequest request) {
		return sessionMap.get(getUuid(request));
	}

	/*
	 * 
	 * 判断是否已经登录账号
	 */
	public boolean isLogin(HttpServletRequest request) {
		String customId = this.getCustomId(request);
		return customId != null;

	}

	@Override
	public String loginOff(HttpServletRequest request) {
		String uuid=this.getUuid(request);
		this.sessionMap.put(uuid, null);
		return "loginOff";
	}

}
