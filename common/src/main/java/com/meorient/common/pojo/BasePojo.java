package com.meorient.common.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @功能:实体基类
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:07:11
 */
public class BasePojo implements Serializable{
	// UID
	private static final long serialVersionUID = 1L;
	
	// 主键
	private Long id;
	
	// 创建人id
	private Long createrId;
	
	// 创建人姓名
	private String createrName;
	
	// 创建时间
	private Timestamp createTime;
	
	// 修改人id
	private Long modId;
	
	// 修改人姓名
	private String modName;
	
	// 修改时间
	private Timestamp modTime;
	
	// 分页：第几页
	private Integer pageNum;
	
	// 分页：每页条数
	private Integer pageSize;
	
	// 分页：查询记录总数
	private Long totalRowCount;

	/**
	 * @取得 id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @设置 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @取得 createrId
	 */
	public Long getCreaterId() {
		return createrId;
	}

	/**
	 * @设置 createrId
	 */
	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	/**
	 * @取得 createrName
	 */
	public String getCreaterName() {
		return createrName;
	}

	/**
	 * @设置 createrName
	 */
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	/**
	 * @取得 createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @设置 createTime
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @取得 modId
	 */
	public Long getModId() {
		return modId;
	}

	/**
	 * @设置 modId
	 */
	public void setModId(Long modId) {
		this.modId = modId;
	}

	/**
	 * @取得 modName
	 */
	public String getModName() {
		return modName;
	}

	/**
	 * @设置 modName
	 */
	public void setModName(String modName) {
		this.modName = modName;
	}

	/**
	 * @取得 modTime
	 */
	public Timestamp getModTime() {
		return modTime;
	}

	/**
	 * @设置 modTime
	 */
	public void setModTime(Timestamp modTime) {
		this.modTime = modTime;
	}

	/**
	 * @取得 pageNum
	 */
	public Integer getPageNum() {
		return pageNum;
	}

	/**
	 * @设置 pageNum
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @取得 pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @设置 pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @取得 totalRowCount
	 */
	public Long getTotalRowCount() {
		return totalRowCount;
	}

	/**
	 * @设置 totalRowCount
	 */
	public void setTotalRowCount(Long totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
}
