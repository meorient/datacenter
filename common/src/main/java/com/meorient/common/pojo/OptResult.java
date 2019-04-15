/**
 * 
 */
package com.meorient.common.pojo;

import java.io.Serializable;

import org.apache.logging.log4j.Logger;

import com.meorient.common.util.JsonTool;

/**
 * @功能:操作结果
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:07:11 
 */
public class OptResult implements Serializable {
	// UID
	private static final long serialVersionUID = -9083945338995608354L;
	
	// 大于 0正确，小于0错误
	private Integer code;
	
	// 标题
	private String title;
	
	// 提示消息
	private String msg;
	
	// 临时参数
	private Object temp;

	/**
	 * 构造方法
	 */
	public OptResult() {
		super();
	}

	/**
	 * 构造方法
	 * 
	 * @param code
	 * @param msg
	 */
	public OptResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 构造方法
	 * 
	 * @param code
	 * @param title
	 * @param msg
	 */
	public OptResult(Integer code, String title, String msg) {
		super();
		this.code = code;
		this.title = title;
		this.msg = msg;
	}

	/**
	 * 构造函数
	 * 
	 * @param code
	 * @param title
	 * @param msg
	 * @param temp
	 */
	public OptResult(Integer code, String title, String msg, Object temp) {
		super();
		this.code = code;
		this.title = title;
		this.msg = msg;
		this.temp = temp;
	}

	/**
	 * @取得 消息代码大于等于0表示正确，小于表示错误
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @设置 消息代码大于等于0表示正确，小于表示错误
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @取得 标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @设置 标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @取得 消息内容
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @设置 消息内容
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @取得 临时参数
	 */
	@SuppressWarnings("unchecked")
	public <T> T getTemp() {
		return (T) temp;
	}

	/**
	 * @设置 临时参数
	 */
	public void setTemp(Object temp) {
		this.temp = temp;
	}

	/**
	 * @方法重写
	 */
	@Override
	public String toString() {
		return JsonTool.getString(this);
	}

	/**
	 * 返回自己并打印log
	 *
	 * @return
	 */
	public OptResult log(Logger logger) {
		return log(logger, "");
	}

	/**
	 * 返回自己并打印log
	 *
	 * @return
	 */
	public OptResult log(Logger logger, Object otherMsg) {
		logger.info(this + "," + JsonTool.getString(otherMsg));
		return this;
	}
}
