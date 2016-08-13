package com.johnbusiness.business.basic.loader;

import java.beans.PropertyVetoException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.johnbusiness.business.basic.dao",
		"com.johnbusiness.business" })
 @EnableJpaRepositories("com.johnbusiness.business.repository")
@EntityScan("com.johnbusiness.business.web.model")
/**
 * 启动类
 */
@PropertySource(value = "classpath:application.properties")
public class Application {
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		manRun(args);
	}

	/**
	 * 默认启动spring boot .
	 * 
	 * @param args
	 *            启动参数，支持
	 */
	public static void defaultRun(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * sb 定制化启动，消除启动的banner .
	 * 
	 * @param args
	 *            启动参数，支持
	 */
	public static void manRun(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		app.run(args);
	}

	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	@Bean
	public BasicDataSource dataSource() throws IllegalStateException,
			PropertyVetoException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env
				.getRequiredProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(env
				.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(env
				.getRequiredProperty("spring.datasource.password"));

		dataSource.setMaxActive(300);
		dataSource.setMaxWait(3000);
		dataSource.setValidationQuery("select 1");
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setInitialSize(10);
		dataSource.setMaxIdle(10);
		dataSource.setLogAbandoned(true);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(180);
		dataSource.setMinIdle(5);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws IllegalStateException,
			PropertyVetoException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory()
			throws IllegalStateException, PropertyVetoException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory;
	}
}
