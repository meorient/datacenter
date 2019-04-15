package com.meorient.phonecall.pojo.user;

import java.util.List;

import com.meorient.common.pojo.BasePojo;
import com.meorient.phonecall.pojo.phonecall.PhoneCall;

/**
 * @功能:用户
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月20日下午2:21:06
 */
public class User extends BasePojo {
	private static final long serialVersionUID = -3885202461593482268L;

	/** 公司id */
	private Long companyId;

	/** 部门id */
	private Long departmentId;

	/** 上级id */
	private Long parentId;

	/** 关联企业微信id */
	private String wechatUserId;

	/** 用户姓名 */
	private String name;

	/** 用户姓名：前端限定结构 */
	private String label;

	/** 电话号码 */
	private String mobile;

	/** 电子邮件 */
	private String email;

	/** 是否离职 */
	private Integer isResigned;

	/** 电话记录 */
	private List<PhoneCall> phoneCallList;

	/** 电话记录:被分享 */
	private List<PhoneCall> phoneCallShareList;

	/** 电话记录中拨打总时长 */
	private Integer callTimeLength;

	/** 企业微信认证code */
	private String code;

	/** 本后台登录token */
	private String token;

	/** 通话总时长 */
	private Integer connectSecondsTotal = 0;

	/** 权限集合 */
//	private List<MyGrantedAuthority> authoritiyList;

	/**
	 * @取得 companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @设置 companyId
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @取得 departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @设置 departmentId
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
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
	 * @取得 wechatUserId
	 */
	public String getWechatUserId() {
		return wechatUserId;
	}

	/**
	 * @设置 wechatUserId
	 */
	public void setWechatUserId(String wechatUserId) {
		this.wechatUserId = wechatUserId;
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
	 * @取得 mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @设置 mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	 * @取得 isResigned
	 */
	public Integer getIsResigned() {
		return isResigned;
	}

	/**
	 * @设置 isResigned
	 */
	public void setIsResigned(Integer isResigned) {
		this.isResigned = isResigned;
	}

	/**
	 * @取得 callTimeLength
	 */
	public Integer getCallTimeLength() {
		return callTimeLength;
	}

	/**
	 * @设置 callTimeLength
	 */
	public void setCallTimeLength(Integer callTimeLength) {
		this.callTimeLength = callTimeLength;
	}

	/**
	 * @取得 phoneCallList
	 */
	public List<PhoneCall> getPhoneCallList() {
		return phoneCallList;
	}

	/**
	 * @设置 phoneCallList
	 */
	public void setPhoneCallList(List<PhoneCall> phoneCallList) {
		this.phoneCallList = phoneCallList;
	}

	/**
	 * @取得 phoneCallShareList
	 */
	public List<PhoneCall> getPhoneCallShareList() {
		return phoneCallShareList;
	}

	/**
	 * @设置 phoneCallShareList
	 */
	public void setPhoneCallShareList(List<PhoneCall> phoneCallShareList) {
		this.phoneCallShareList = phoneCallShareList;
	}

	/**
	 * @取得 code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @设置 code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @取得 token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @设置 token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @取得 connectSecondsTotal
	 */
	public Integer getConnectSecondsTotal() {
		return connectSecondsTotal;
	}

	/**
	 * @设置 connectSecondsTotal
	 */
	public void setConnectSecondsTotal(Integer connectSecondsTotal) {
		this.connectSecondsTotal = connectSecondsTotal;
	}

//	/**
//	 * @取得 authoritiyList
//	 */
//	public List<MyGrantedAuthority> getAuthoritiyList() {
//		return authoritiyList;
//	}
//
//	/**
//	 * @设置 authoritiyList
//	 */
//	public void setAuthoritiyList(List<MyGrantedAuthority> authoritiyList) {
//		this.authoritiyList = authoritiyList;
//	}
}
