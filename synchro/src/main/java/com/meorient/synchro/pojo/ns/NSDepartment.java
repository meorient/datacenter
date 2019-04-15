package com.meorient.synchro.pojo.ns;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年4月3日上午10:02:14
 */
public class NSDepartment extends BasePojo {
	private static final long serialVersionUID = 1L;

	private Long department_Id;

	private String name;

	private Long parent_Id;

	/**
	 * @取得 department_Id
	 */
	public Long getDepartment_Id() {
		return department_Id;
	}

	/**
	 * @设置 department_Id
	 */
	public void setDepartment_Id(Long department_Id) {
		this.department_Id = department_Id;
	}

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
	 * @取得 parent_Id
	 */
	public Long getParent_Id() {
		return parent_Id;
	}

	/**
	 * @设置 parent_Id
	 */
	public void setParent_Id(Long parent_Id) {
		this.parent_Id = parent_Id;
	}
}
