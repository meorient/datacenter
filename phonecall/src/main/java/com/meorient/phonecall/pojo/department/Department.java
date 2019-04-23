/** */
package com.meorient.phonecall.pojo.department;

import java.util.List;

import com.meorient.common.pojo.BasePojo;
import com.meorient.phonecall.pojo.user.User;
import lombok.Data;

/**
 * @功能: 部门
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39 @说明：
 * 
 *                <pre></pre>
 */
@Data
public class Department extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;

	/** 部门经理id */
	private Long managerId;

	/** 部门经理姓名 */
	private String managerName;

	/** 部门名称 */
	private String name;

	/** 部门名称：前台限定结构 */
	private String label;

	/** 上级部门id */
	private Long parentId;

	/** 是否拥有被分享权力 */
	private Long shareMark;

	/** 部门用户 */
	private List<User> children;

	/** 查询参数：用户id */
	private Long userId;

}
