package com.johnbusiness.business.web.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnbusiness.business.basic.dao.BaseJdbcDao;
import com.johnbusiness.business.repository.BCustomerRepository;
import com.johnbusiness.business.web.model.BCustomer;

@Service
public class CustomDao extends BaseJdbcDao{
	
	@Autowired
	private BCustomerRepository bCustomerRepository;
	
	@Transactional(readOnly=false)
	public String save(BCustomer custom) {
		String id = UUID.randomUUID().toString();
		custom.setId(id);
		bCustomerRepository.save(custom);
		return id;
	}

	public BCustomer getCustomer(BCustomer custom) {
		return bCustomerRepository.findOne(custom.getId());
	}

}
