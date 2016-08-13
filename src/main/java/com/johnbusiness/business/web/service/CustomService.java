package com.johnbusiness.business.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnbusiness.business.web.dao.CustomDao;
import com.johnbusiness.business.web.model.BCustomer;

@Service
public class CustomService {
	@Autowired
	private CustomDao customDao;
	
	@Transactional
	public String save(BCustomer custom) {
		return customDao.save(custom);
	}

	public BCustomer getCustomer(BCustomer custom) {
		return customDao.getCustomer(custom);
	}
}
