package com.meorient.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @功能:实体基类
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:07:11
 */
@Data
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


}
