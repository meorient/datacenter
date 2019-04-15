package com.meorient.synchro.pojo.dynamics;

import java.sql.Timestamp;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年4月4日下午12:54:34
 */
public class DyPhoneCall extends BasePojo {
	/** UID */
	private static final long serialVersionUID = 3961039371234907760L;

	/** 用户姓名 */
	private String ownerIdName;

	/** 主叫号码 */
	private String new_tonum;

	/** 被叫号码 */
	private String new_fromnum;

	/** 文字记录 */
	private String description;

	/** 语音记录 */
	private String new_recordlink;

	/** 拨打时间 */
	private Timestamp new_begintime;

	/** 接通时间 */
	private Timestamp new_connectTime;

	/** 挂断时间 */
	private Timestamp new_dialtime;

	/** 文件id */
	private String new_ucid;

	/** 查询参数：起始时间 */
	private Timestamp beginTime;

	/** 查询参数：结束时间 */
	private Timestamp endTime;

	/** 查询参数：查询数量 */
	private Integer rowSize;

	/** 查询参数：起始位置 */
	private Integer rowNum;

	/**
	 * @取得 ownerIdName
	 */
	public String getOwnerIdName() {
		return ownerIdName;
	}

	/**
	 * @设置 ownerIdName
	 */
	public void setOwnerIdName(String ownerIdName) {
		this.ownerIdName = ownerIdName;
	}

	/**
	 * @取得 new_tonum
	 */
	public String getNew_tonum() {
		return new_tonum;
	}

	/**
	 * @设置 new_tonum
	 */
	public void setNew_tonum(String new_tonum) {
		this.new_tonum = new_tonum;
	}

	/**
	 * @取得 new_fromnum
	 */
	public String getNew_fromnum() {
		return new_fromnum;
	}

	/**
	 * @设置 new_fromnum
	 */
	public void setNew_fromnum(String new_fromnum) {
		this.new_fromnum = new_fromnum;
	}

	/**
	 * @取得 description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @设置 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @取得 new_recordlink
	 */
	public String getNew_recordlink() {
		return new_recordlink;
	}

	/**
	 * @设置 new_recordlink
	 */
	public void setNew_recordlink(String new_recordlink) {
		this.new_recordlink = new_recordlink;
	}

	/**
	 * @取得 new_ucid
	 */
	public String getNew_ucid() {
		return new_ucid;
	}

	/**
	 * @设置 new_ucid
	 */
	public void setNew_ucid(String new_ucid) {
		this.new_ucid = new_ucid;
	}

	/**
	 * @取得 new_begintime
	 */
	public Timestamp getNew_begintime() {
		return new_begintime;
	}

	/**
	 * @设置 new_begintime
	 */
	public void setNew_begintime(Timestamp new_begintime) {
		this.new_begintime = new_begintime;
	}

	/**
	 * @取得 new_connectTime
	 */
	public Timestamp getNew_connectTime() {
		return new_connectTime;
	}

	/**
	 * @设置 new_connectTime
	 */
	public void setNew_connectTime(Timestamp new_connectTime) {
		this.new_connectTime = new_connectTime;
	}

	/**
	 * @取得 new_dialtime
	 */
	public Timestamp getNew_dialtime() {
		return new_dialtime;
	}

	/**
	 * @设置 new_dialtime
	 */
	public void setNew_dialtime(Timestamp new_dialtime) {
		this.new_dialtime = new_dialtime;
	}

	/**
	 * @取得 beginTime
	 */
	public Timestamp getBeginTime() {
		return beginTime;
	}

	/**
	 * @设置 beginTime
	 */
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @取得 endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * @设置 endTime
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * @取得 rowSize
	 */
	public Integer getRowSize() {
		return rowSize;
	}

	/**
	 * @设置 rowSize
	 */
	public void setRowSize(Integer rowSize) {
		this.rowSize = rowSize;
	}

	/**
	 * @取得 rowNum
	 */
	public Integer getRowNum() {
		return rowNum;
	}

	/**
	 * @设置 rowNum
	 */
	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
}
