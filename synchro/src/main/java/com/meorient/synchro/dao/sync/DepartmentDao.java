/** */
package com.meorient.synchro.dao.sync;

import org.springframework.stereotype.Repository;

import com.meorient.synchro.dao.BaseMysqlDao;
import com.meorient.synchro.pojo.sync.Department;

/**
 * @功能:【department 】Dao
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
@Repository
public class DepartmentDao extends BaseMysqlDao<Department> {
	
	/**
	 * avaya ns部门修正上属部门id为主键id
	 * @param department
	 * @return
	 */
	public int fixParentId(Department department) {
		return this.update("fixParentId", department);
	}
}
