package com.meorient.phonecall.pojo.amap;

/**
 * 功能:
 * 项目名:phonecall
 * 作者:chuxu
 * 日期:2019年5月7日上午11:35:09
 */
public class Geocode {
	private String formatted_address;
	private String country;
	private String province;
	private String city;
	private String citycode;
	private String adcode;
	private String location;//"120.155070,30.274084"

	/**
	 * 取得 formatted_address
	 */
	public String getFormatted_address() {
		return formatted_address;
	}

	/**
	 * 设置 formatted_address
	 */
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	/**
	 * 取得 country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置 country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 取得 province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置 province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 取得 city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置 city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 取得 citycode
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * 设置 citycode
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	/**
	 * 取得 adcode
	 */
	public String getAdcode() {
		return adcode;
	}

	/**
	 * 设置 adcode
	 */
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	/**
	 * 取得 location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 设置 location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
