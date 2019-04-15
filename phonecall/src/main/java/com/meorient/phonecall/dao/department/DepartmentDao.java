/** */
package com.meorient.phonecall.dao.department;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meorient.phonecall.dao.base.BaseDao;
import com.meorient.phonecall.pojo.department.Department;

/**
 * @功能:【department 】Dao
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
@Repository
public class DepartmentDao extends BaseDao<Department> {
  	/**
	 * 查询分享范围内用户
	 * @param department
	 */
	public List<Department> getShareAbleUserList(Department department) {
		return this.selectList("getShareAbleUserList",department);
	}
}
