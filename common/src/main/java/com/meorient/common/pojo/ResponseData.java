/**
 * 
 */
package com.meorient.common.pojo;

import java.io.Serializable;

import com.meorient.common.util.JsonTool;

/**
 * @功能: request请求返回的数据
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:07:11 
 */
public class ResponseData implements Serializable {
	// UID
	private static final long serialVersionUID = -6146242610931501695L;
	
	// 请求结果
	private OptResult reqResult;
	
	// 数据 
	private Object data;
	
	// 查询总记录数
	private Long total;

	/**
	 * @构造方法
	 */
	public ResponseData() {
		super();
	}

	/**
	 * @构造方法
	 * @param reqResult
	 */
	public ResponseData(OptResult reqResult) {
		super();
		this.reqResult = reqResult;
	}

	/**
	 * @构造方法
	 * @param reqResult
	 * @param data
	 */
	public ResponseData(OptResult reqResult, Object data) {
		super();
		this.reqResult = reqResult;
		this.data = data;
	}

	/**
	 * 构造函数
	 * 
	 * @param reqResult
	 * @param data
	 * @param total
	 */
	public ResponseData(OptResult reqResult, Object data, Long total) {
		super();
		this.reqResult = reqResult;
		this.data = data;
		this.total = total;
	}

	/**
	 * @取得 请求结果
	 */
	public OptResult getReqResult() {
		return reqResult;
	}

	/**
	 * @设置 请求结果
	 */
	public void setReqResult(OptResult reqResult) {
		this.reqResult = reqResult;
	}

	/**
	 * @取得 数据
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @设置 数据
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @取得 查询总记录数
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @设置 查询总记录数
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @方法重写
	 */
	@Override
	public String toString() {
		return JsonTool.getString(this);
	}

}
