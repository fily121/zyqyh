package com.johnbusiness.business.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "b_role")
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6782711090138028485L;
	private String id;
	private String role;
	private String roleDetail;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the id
	 */
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Id
    @Column(name="id", unique=true, nullable=false, length=16)
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the roleDetail
	 */
	@Column(name="roleDetail", length=50)
	public String getRoleDetail() {
		return roleDetail;
	}

	/**
	 * @param roleDetail
	 *            the roleDetail to set
	 */
	public void setRoleDetail(String roleDetail) {
		this.roleDetail = roleDetail;
	}
}
