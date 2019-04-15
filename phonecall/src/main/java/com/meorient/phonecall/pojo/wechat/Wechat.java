package com.meorient.phonecall.pojo.wechat;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能:微信
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日下午4:20:04
 */
public class Wechat extends BasePojo {
	/** UID */
	private static final long serialVersionUID = 5866642735249395301L;

	/** access_token */
	private String access_token;

	/** access_token */
	private String contact_access_token;

	/** access_token */
	private String provider_access_token;

	/** 用户userId */
	private String userId;
	
	/** 用户code */
	private String code;

	/** User_ticket */
	private String user_ticket;

	/** 用户email */
	private String email;

	/** 用户手机号码 */
	private String mobile;

	/**
	 * @取得 access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @设置 access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @取得 provider_access_token
	 */
	public String getProvider_access_token() {
		return provider_access_token;
	}

	/**
	 * @设置 provider_access_token
	 */
	public void setProvider_access_token(String provider_access_token) {
		this.provider_access_token = provider_access_token;
	}

	/**
	 * @取得 userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @设置 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @取得 user_ticket
	 */
	public String getUser_ticket() {
		return user_ticket;
	}

	/**
	 * @设置 user_ticket
	 */
	public void setUser_ticket(String user_ticket) {
		this.user_ticket = user_ticket;
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
	 * @取得 contact_access_token
	 */
	public String getContact_access_token() {
		return contact_access_token;
	}

	/**
	 * @设置 contact_access_token
	 */
	public void setContact_access_token(String contact_access_token) {
		this.contact_access_token = contact_access_token;
	}
}
