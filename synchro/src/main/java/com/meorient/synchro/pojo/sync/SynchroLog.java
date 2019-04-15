package com.meorient.synchro.pojo.sync;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能: 【同步数据记录】
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年4月3日下午7:52:30
 */
public class SynchroLog extends BasePojo {
	/** UID */
	private static final long serialVersionUID = -743476534148927768L;
	/** 同步来源 */
	private String source;
	/** 同步表 */
	private String tableName;
	/** 同步内容 */
	private String content;
	/** 同步结果 */
	private Integer result;

	/**
	 * @取得 source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @设置 source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @取得 tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @设置 tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @取得 content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @设置 content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @取得 result
	 */
	public Integer getResult() {
		return result;
	}

	/**
	 * @设置 result
	 */
	public void setResult(Integer result) {
		this.result = result;
	}

}
