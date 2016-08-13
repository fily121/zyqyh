package com.johnbusiness.business.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.johnbusiness.business.util.CustomUtil;
import com.johnbusiness.business.web.model.BCustomer;
import com.johnbusiness.business.web.service.CustomService;

@Controller
public class CustomController {
	@Autowired
	private CustomService customService;
	
	@RequestMapping("/custSearch")
	public ModelAndView custSearch(ModelAndView mv, HttpServletRequest request) {
		if (CustomUtil.isLogin(request)) {
			mv.setViewName("/");
			return mv;
		}
		
		mv.setViewName("custSearch");
		return mv;
	}

	@RequestMapping("/regCustom")
	public ModelAndView regCustom(ModelAndView mv, HttpServletRequest request, BCustomer custom) {
		if (CustomUtil.isLogin(request)) {
			mv.setViewName("/");
			return mv;
		}
		mv.setViewName("regCustom");
		return mv;
	}
	
	@RequestMapping("/customPay")
	public ModelAndView customPay(ModelAndView mv, HttpServletRequest request, BCustomer custom) {
		if (CustomUtil.isLogin(request)) {
			mv.setViewName("/");
			return mv;
		}
		mv.setViewName("customPay");
		return mv;
	}
	
	@RequestMapping("/customDetail")
	public ModelAndView customDetail(ModelAndView mv, HttpServletRequest request, BCustomer custom) {
		if (CustomUtil.isLogin(request)) {
			mv.setViewName("/welcome");
			return mv;
		}
		BCustomer customer = customService.getCustomer(custom);
		mv.setViewName("customDetail");
		mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping(value = "/regCustom", method = RequestMethod.POST)
	@ResponseBody
	public String regCustomSave(HttpServletRequest request, BCustomer custom) {
		if (CustomUtil.isLogin(request)) {
			return "";
		}
		
		return customService.save(custom);
	}
}
