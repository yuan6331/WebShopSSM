package com.gdut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.entity.Custom;
import com.gdut.mapper.CustomMapper;
import com.gdut.service.CustomService;

@Service
public class CustomServiceImpl implements CustomService{

	@Autowired
	CustomMapper cm;
	

	@Override
	public Custom queryCustom(String customId) {
		return cm.queryCustom(customId);
	}



}
