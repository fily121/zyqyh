package com.johnbusiness.business.repository;

import org.springframework.data.repository.CrudRepository;

import com.johnbusiness.business.web.model.BCustomer;

public interface BCustomerRepository extends CrudRepository<BCustomer, String>{

}
