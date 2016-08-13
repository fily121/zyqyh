/** ~ CopyRight © 2012 China Mobile Group Anhui CO.,LTD All Rights Reserved. */
package com.johnbusiness.business.basic.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

/**
 * 基础的JDBC dao实现.
 * 
 * @author dingbing
 *
 * @param <T>
 *            保存实体
 * @param <ID>
 *            主键
 */
@Component
public class BaseJdbcDao extends HibernateDaoSupport {
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
