package com.johnbusiness.business.web.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * BCustom entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="b_customer")
public class BCustomer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3625407284797752953L;
	private String id;
	private String username;
	private String password;
	private boolean enabled;
	private String custname;
	private String mobile;
	private String idcard;
	private String address;
	private String gender;
	private String birthday;

	// Constructors

	/** default constructor */
	public BCustomer() {
	}

	/** minimal constructor */
	public BCustomer(String idcard) {
		this.idcard = idcard;
	}

	/** full constructor */
	public BCustomer(String custname, String mobile, String idcard,
			String address, String prep) {
		this.custname = custname;
		this.mobile = mobile;
		this.idcard = idcard;
		this.address = address;
	}

	// Property accessors
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Id
    @Column(name="id", unique=true, nullable=false, length=16)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="custname", length=16)
	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	@Column(name="mobile", length=11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="idcard", length=18)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name="address", length=100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the birthday
	 */
	@Column(name="birthday", length=10)
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}