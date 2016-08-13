package com.johnbusiness.business.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnbusiness.business.web.dao.LoginDao;
import com.johnbusiness.business.web.model.BCustomer;

@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;

	public BCustomer authUser(String username, String password) {
		BCustomer buser = loginDao.authUser(username, password);
		return buser;
	}
}
