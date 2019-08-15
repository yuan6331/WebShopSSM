package com.gdut.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdut.entity.Goods;
import com.gdut.service.impl.CustomServiceImpl;
import com.gdut.service.impl.GoodsServiceImpl;
import com.gdut.service.impl.LoginServiceImpl;

@Controller
@RequestMapping("beforeLogin")
public class LoginHandler {


	@Autowired
	CustomServiceImpl customService;

	@Autowired
	GoodsServiceImpl goodsService;
	
	@Autowired
	LoginServiceImpl loginService;
	
	/*
	 * 
	 * 登陆验证
	 */
	@RequestMapping(value="loginAction",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String loginHandler(String customId,String customPwd) {
		return loginService.login(customId, customPwd);
	}

	List<Goods> goodsList = new ArrayList<>();
	
	/*
	 * 按商品名称查询
	 */
	@RequestMapping(value = "queryGoodsByGoodsName")
	public String queryGoodsByGoodsName(@RequestParam String goodsName, Model model) {
		goodsList=goodsService.queryGoodsByName(goodsName);
		model.addAttribute("goodsList", goodsList);
		return "beforeLogin/goodsList";
	}
	
	/*
	 * 查询所有的商品
	 */
	@RequestMapping(value="queryAllGoods")
	public String queryAllgoods(Model model) {
		goodsList=goodsService.queryAllGoods();
		model.addAttribute("goodsList", goodsList);
		return "beforeLogin/goodsList";
	}
	/*
	 * 退出账号
	 */
	@RequestMapping("loginOff")
	@ResponseBody
	public String loginOff(HttpServletRequest request){
		System.out.println("loginOff");
		return loginService.loginOff(request);
	}
	
	
	@RequestMapping("test")
	public String test(){
		return "NewFile";
	}
}
