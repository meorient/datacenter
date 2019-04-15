/**
 * 
 */
package com.meorient.common.configuration;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @功能:Session配置
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:16:27
 */
@Component
@ConfigurationProperties(prefix = "common.sysConfig.cfgResAndSessionParam")
public class CfgResAndSessionParam implements Serializable {
	/** UID */
	private static final long serialVersionUID = -6164270468382182889L;
	
	/** session过期时长,单位：分钟 */
	private int sessionExp;
	
	/** 图片等资源存放站点根目录 */
	private String resRootUrl;
	
	/** 是否发布模式 */
	private boolean releaseMode;
	
	/** 签名验证超时时间限制 单位：分钟 */
	private int authTimeLimit;

	/**
	 * @取得 session过期时长单位：分钟，默认30分钟
	 */
	public int getSessionExp() {
		return sessionExp;
	}

	/**
	 * @设置 session过期时长单位：分钟，默认30分钟
	 */
	public void setSessionExp(int sessionExp) {
		this.sessionExp = sessionExp;
	}

	/**
	 * @取得 图片等资源存放站点根目录
	 */
	public String getResRootUrl() {
		return resRootUrl;
	}

	/**
	 * @设置 图片等资源存放站点根目录
	 */
	public void setResRootUrl(String resRootUrl) {
		this.resRootUrl = resRootUrl;
	}

	/**
	 * @取得 是否发布模式
	 */
	public boolean getReleaseMode() {
		return releaseMode;
	}

	/**
	 * @设置 是否发布模式
	 */
	public void setReleaseMode(boolean releaseMode) {
		this.releaseMode = releaseMode;
	}

	/**
	 * @取得 签名验证超时时间限制 单位：分种
	 */
	public int getAuthTimeLimit() {
		return authTimeLimit;
	}

	/**
	 * @设置 签名验证超时时间限制 单位：分种
	 */
	public void setAuthTimeLimit(int authTimeLimit) {
		this.authTimeLimit = authTimeLimit;
	}
}
