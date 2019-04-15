/** */
package com.meorient.phonecall.pojo.department;

import java.util.List;

import com.meorient.common.pojo.BasePojo;
import com.meorient.phonecall.pojo.user.User;

/**
 * @功能: 部门
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39 @说明：
 * 
 *                <pre></pre>
 */
public class Department extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;

	/** 部门经理id */
	private Long managerId;

	/** 部门经理姓名 */
	private String managerName;

	/** 部门名称 */
	private String name;

	/** 部门名称：前台限定结构 */
	private String label;

	/** 上级部门id */
	private Long parentId;

	/** 是否拥有被分享权力 */
	private Long shareMark;

	/** 部门用户 */
	private List<User> children;

	/** 查询参数：用户id */
	private Long userId;

	/**
	 * @取得 managerId
	 */
	public Long getManagerId() {
		return managerId;
	}

	/**
	 * @设置 managerId
	 */
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	/**
	 * @取得 managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @设置 managerName
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
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
	 * @取得 label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @设置 label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @取得 parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @设置 parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @取得 shareMark
	 */
	public Long getShareMark() {
		return shareMark;
	}

	/**
	 * @设置 shareMark
	 */
	public void setShareMark(Long shareMark) {
		this.shareMark = shareMark;
	}

	/**
	 * @取得 children
	 */
	public List<User> getChildren() {
		return children;
	}

	/**
	 * @设置 children
	 */
	public void setChildren(List<User> children) {
		this.children = children;
	}

	/**
	 * @取得 userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @设置 userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
