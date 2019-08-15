package com.gdut.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class goodsHandler {
	@RequestMapping("turnPage")
	public int turnPage(int currentPage){
		
		return currentPage; 
	}

}
