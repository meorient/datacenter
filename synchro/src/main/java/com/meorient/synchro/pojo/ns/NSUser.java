package com.meorient.synchro.pojo.ns;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能:NS【Employees】
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年4月3日下午8:50:27
 */
public class NSUser extends BasePojo {
	/** UID */
	private static final long serialVersionUID = -2564329123789612890L;
	/** NS系统用户唯一id */
	private Long employee_id;
	/** 姓名 */
	private String name;
	/** 电子邮箱 */
	private String email;
	/** 部门id */
	private Long department_id;

	/**
	 * @取得 name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @设置 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @取得 email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @设置 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @取得 employee_id
	 */
	public Long getEmployee_id() {
		return employee_id;
	}

	/**
	 * @设置 employee_id
	 */
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * @取得 department_id
	 */
	public Long getDepartment_id() {
		return department_id;
	}

	/**
	 * @设置 department_id
	 */
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
}
