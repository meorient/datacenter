/** */
package com.meorient.synchro.service.iservice.sync;

import java.sql.Timestamp;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.synchro.pojo.ns.NSDepartment;
import com.meorient.synchro.pojo.sync.Department;

/**
 * @功能:【department 】IService
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
public interface IDepartmentService extends IBaseService<Department> {
	/**
	 * avaya ns部门增量同步
	 * @param nsDepartment
	 * @return
	 */
	public int nsAddSync(NSDepartment nsDepartment,Timestamp now);
	
	/**
	 * avaya ns部门修改同步
	 * @param nsDepartment
	 * @return
	 */
	public int nsModSync(NSDepartment nsDepartment,Timestamp now);
	
	/**
	 * avaya ns部门修正上属部门id为主键id
	 * @param nsDepartment
	 * @return
	 */
	public void nsFixSync(Department department);
	
	/**
	 * 检查是否需要同步
	 * @param nsDepartment
	 * @return
	 */
	public boolean checkSync(NSDepartment nsDepartment,Department department);
}
