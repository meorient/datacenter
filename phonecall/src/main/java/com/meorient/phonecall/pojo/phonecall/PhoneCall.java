package com.meorient.phonecall.pojo.phonecall;

import java.sql.Timestamp;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能: 电话记录
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午8:38:18
 */
public class PhoneCall extends BasePojo {
	/** UID */
	private static final long serialVersionUID = 3961039371234907760L;

	/** 来源 */
	private String sourceId;

	/** 涉及用户 */
	private Long userId;

	/** 主叫号码 */
	private String fromTel;

	/** 被叫号码 */
	private String toTel;

	/** 呼叫类型 */
	private Integer DirectType;

	/** 分机号码 */
	private String extTel;

	/** 文字记录 */
	private String recordText;

	/** 语音记录 */
	private String recordUrl;

	/** 拨打时间 */
	private Timestamp callTime;

	/** 接通时间 */
	private Timestamp connectTime;

	/** 挂断时间 */
	private Timestamp disconnectTime;

	/** 通话时长 */
	private Integer connectSeconds;

	/** 拨打状态 */
	private Integer callStatus;

	/** 部门id */
	private Long departmentId;

	/**
	 * @取得 sourceId
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * @设置 sourceId
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @取得 userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @设置 userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @取得 recordText
	 */
	public String getRecordText() {
		return recordText;
	}

	/**
	 * @设置 recordText
	 */
	public void setRecordText(String recordText) {
		this.recordText = recordText;
	}

	/**
	 * @取得 recordUrl
	 */
	public String getRecordUrl() {
		return recordUrl;
	}

	/**
	 * @设置 recordUrl
	 */
	public void setRecordUrl(String recordUrl) {
		this.recordUrl = recordUrl;
	}

	/**
	 * @取得 fromTel
	 */
	public String getFromTel() {
		return fromTel;
	}

	/**
	 * @设置 fromTel
	 */
	public void setFromTel(String fromTel) {
		this.fromTel = fromTel;
	}

	/**
	 * @取得 toTel
	 */
	public String getToTel() {
		return toTel;
	}

	/**
	 * @设置 toTel
	 */
	public void setToTel(String toTel) {
		this.toTel = toTel;
	}

	/**
	 * @取得 directType
	 */
	public Integer getDirectType() {
		return DirectType;
	}

	/**
	 * @设置 directType
	 */
	public void setDirectType(Integer directType) {
		DirectType = directType;
	}

	/**
	 * @取得 extTel
	 */
	public String getExtTel() {
		return extTel;
	}

	/**
	 * @设置 extTel
	 */
	public void setExtTel(String extTel) {
		this.extTel = extTel;
	}

	/**
	 * @取得 callTime
	 */
	public Timestamp getCallTime() {
		return callTime;
	}

	/**
	 * @设置 callTime
	 */
	public void setCallTime(Timestamp callTime) {
		this.callTime = callTime;
	}

	/**
	 * @取得 connectTime
	 */
	public Timestamp getConnectTime() {
		return connectTime;
	}

	/**
	 * @设置 connectTime
	 */
	public void setConnectTime(Timestamp connectTime) {
		this.connectTime = connectTime;
	}

	/**
	 * @取得 disconnectTime
	 */
	public Timestamp getDisconnectTime() {
		return disconnectTime;
	}

	/**
	 * @设置 disconnectTime
	 */
	public void setDisconnectTime(Timestamp disconnectTime) {
		this.disconnectTime = disconnectTime;
	}

	/**
	 * @取得 connectSeconds
	 */
	public Integer getConnectSeconds() {
		return connectSeconds;
	}

	/**
	 * @设置 connectSeconds
	 */
	public void setConnectSeconds(Integer connectSeconds) {
		this.connectSeconds = connectSeconds;
	}

	/**
	 * @取得 callStatus
	 */
	public Integer getCallStatus() {
		return callStatus;
	}

	/**
	 * @设置 callStatus
	 */
	public void setCallStatus(Integer callStatus) {
		this.callStatus = callStatus;
	}

	/**
	 * @取得 serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @取得 departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @设置 departmentId
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
