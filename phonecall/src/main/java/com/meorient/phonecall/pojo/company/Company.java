/** */
package com.meorient.phonecall.pojo.company;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能: 公司
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 12:23:09
 * @说明：<pre></pre>
 */
public class Company extends BasePojo {
	/** UID */
	private static final long serialVersionUID = 6503279628098785149L;
	
	/** 公司名称 */
	private String name;
	
	/** 公司电话 */
	private String phone;
	
	/** @取得 公司名称 */
	public String getName(){
		return name;
	}
	
	/** @设置 公司名称 */
	public void setName(String name){
		this.name = name;
	}
	
	/** @取得 公司电话 */
	public String getPhone(){
		return phone;
	}
	
	/** @设置 公司电话 */
	public void setPhone(String phone){
		this.phone = phone;
	}

}
