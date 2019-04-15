package com.meorient.phonecall.pojo.sysauthinfo;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能: 授权信息
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月20日下午2:45:43
 */
public class SysAuthInfo extends BasePojo{
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	
	/** 账号 */
	private String account;
	
	/** 密钥 */
	private String secret;
	
	/** 备注 */
	private String remark;
	
	/** 状态(0停用、1正常) */
	private Integer status;

	/** @取得 账号 */
	public String getAccount() {
		return account;
	}

	/** @设置 账号 */
	public void setAccount(String account) {
		this.account = account;
	}

	/** @取得 密钥 */
	public String getSecret() {
		return secret;
	}

	/** @设置 密钥 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/** @取得 备注 */
	public String getRemark() {
		return remark;
	}

	/** @设置 备注 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** @取得 状态(0停用、1正常) */
	public Integer getStatus() {
		return status;
	}

	/** @设置 状态(0停用、1正常) */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
