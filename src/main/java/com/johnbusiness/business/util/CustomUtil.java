package com.johnbusiness.business.util;

import javax.servlet.http.HttpServletRequest;

public class CustomUtil {
	public static final boolean isLogin(HttpServletRequest request) {
		return request.getSession().getAttribute("user") == null;
	}
}
