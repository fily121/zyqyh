package com.johnbusiness.business.web.dao;

import org.springframework.stereotype.Service;

import com.johnbusiness.business.basic.dao.BaseJdbcDao;
import com.johnbusiness.business.web.model.BCustomer;

@Service
public class LoginDao extends BaseJdbcDao {

	public BCustomer authUser(String username, String password) {
		String sql = "select username from b_user left join user_role on b_user.id = user_role.userid left join b_role on user_role.roleid=b_bole.id where b_user.username=? and b_user.password=?";
		return (BCustomer) this.jdbcTemplate.queryForList(sql, BCustomer.class, username, password);
	}

	public BCustomer findByUserName(String username) {
		String sql = "select username from b_user left join user_role on b_user.id = user_role.userid left join b_role on user_role.roleid=b_bole.id where b_user.username=?";
		return (BCustomer) this.jdbcTemplate.queryForList(sql, BCustomer.class, username);
	}

}
