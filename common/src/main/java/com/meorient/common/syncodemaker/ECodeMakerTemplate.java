package com.meorient.common.syncodemaker;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年4月22日下午4:59:07
 */
public enum ECodeMakerTemplate {
	task("task.java"),
	service("service.java"),
	dao("dao.java"),
	sql("xml");
	
	String name;
	
	ECodeMakerTemplate(String name) {
		this.name = name;
	}

	/**
	 * @取得 name
	 */
	public String getName() {
		return name;
	}
}
