package com.meorient.phonecall.pojo.amap;

import java.util.List;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年5月7日上午11:34:56
 */
public class Response {

	private Integer status;

	private String info;

	private String infoCode;

	private Integer count;

	private List<Geocode> geocodes;

	/**
	 * @取得 status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @设置 status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @取得 info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @设置 info
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @取得 infoCode
	 */
	public String getInfoCode() {
		return infoCode;
	}

	/**
	 * @设置 infoCode
	 */
	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	/**
	 * @取得 count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @设置 count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @取得 geocodes
	 */
	public List<Geocode> getGeocodes() {
		return geocodes;
	}

	/**
	 * @设置 geocodes
	 */
	public void setGeocodes(List<Geocode> geocodes) {
		this.geocodes = geocodes;
	}

}
