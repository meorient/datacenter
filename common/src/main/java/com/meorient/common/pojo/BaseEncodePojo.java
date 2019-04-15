package com.meorient.common.pojo;

/**
 * @功能:加密参数基类
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:15:15
 */
public class BaseEncodePojo extends BasePojo{
	// UID
	private static final long serialVersionUID = 1L;
	
	// 手机号码（未加密）
	private String tel;
	
	// 手机号码（已加密）
	private String telEnc;
	
	/**
	 * @取得 tel
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * @设置 tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * @取得 telEnc
	 */
	public String getTelEnc() {
		return telEnc;
	}
	
	/**
	 * @设置 telEnc
	 */
	public void setTelEnc(String telEnc) {
		this.telEnc = telEnc;
	}
}
