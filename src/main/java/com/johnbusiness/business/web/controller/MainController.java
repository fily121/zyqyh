package com.johnbusiness.business.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.johnbusiness.business.util.CustomUtil;
import com.johnbusiness.business.web.model.BCustomer;
import com.johnbusiness.business.web.service.LoginService;

@Controller
public class MainController {
	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public ModelAndView welcome(ModelAndView mv) {
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping("/welcome")
	public ModelAndView view(ModelAndView mv) {
		mv.setViewName("welcome");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView main(ModelAndView mv, HttpServletRequest request) {
		if (CustomUtil.isLogin(request)) {
			mv.setViewName("/welcome");
			return mv;
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mv, String username,
			String password, HttpServletRequest request) {
		BCustomer user  = loginService.authUser(username, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			mv.setViewName("main");
			return mv;
		}

		mv.setViewName("/welcome");
		return mv;
	}
}
