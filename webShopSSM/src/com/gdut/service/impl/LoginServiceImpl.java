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
			return "�˺����벻��Ϊ�գ�";
		}
		Custom custom = customMapper.queryCustom(customId);
		if (custom == null) {
			return "���˺�δע�ᣡ";
		}
		if (customPwd.equals(custom.getcustomPwd())) {
			String uuid = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("sessionId", uuid);
			cookie.setPath("/");
			response.addCookie(cookie);
			this.keepCustomId(uuid, customId);
			return "right";
		}
		return "�������";
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
	 * ��ȡcookie���Ѿ���¼��id
	 */
	public String getCustomId(HttpServletRequest request) {
		return sessionMap.get(getUuid(request));
	}

	/*
	 * 
	 * �ж��Ƿ��Ѿ���¼�˺�
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
