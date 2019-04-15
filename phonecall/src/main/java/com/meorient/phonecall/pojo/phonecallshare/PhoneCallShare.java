/** */
package com.meorient.phonecall.pojo.phonecallshare;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能: 电话记录分享
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:20:47 
 * @说明：
 */
public class PhoneCallShare extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;

	/** 被分享电话记录id */
	private Long phoneCallId;

	/** 分享人id */
	private Long shareFromId;

	/** 分享人姓名 */
	private String shareFromName;

	/** 被分享人id */
	private Long shareToId;

	/** 被分享人姓名 */
	private String shareToName;

	/** 是否生效 */
	private Integer status;

	/** @取得 被分享电话记录id */
	public Long getPhoneCallId() {
		return phoneCallId;
	}

	/** @设置 被分享电话记录id */
	public void setPhoneCallId(Long phoneCallId) {
		this.phoneCallId = phoneCallId;
	}

	/** @取得 分享人id */
	public Long getShareFromId() {
		return shareFromId;
	}

	/** @设置 分享人id */
	public void setShareFromId(Long shareFromId) {
		this.shareFromId = shareFromId;
	}

	/** @取得 分享人姓名 */
	public String getShareFromName() {
		return shareFromName;
	}

	/** @设置 分享人姓名 */
	public void setShareFromName(String shareFromName) {
		this.shareFromName = shareFromName;
	}

	/** @取得 被分享人id */
	public Long getShareToId() {
		return shareToId;
	}

	/** @设置 被分享人id */
	public void setShareToId(Long shareToId) {
		this.shareToId = shareToId;
	}

	/** @取得 被分享人姓名 */
	public String getShareToName() {
		return shareToName;
	}

	/** @设置 被分享人姓名 */
	public void setShareToName(String shareToName) {
		this.shareToName = shareToName;
	}

	/** @取得 是否生效 */
	public Integer getStatus() {
		return status;
	}

	/** @设置 是否生效 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
