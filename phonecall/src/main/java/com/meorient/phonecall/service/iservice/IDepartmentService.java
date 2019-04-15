/** */
package com.meorient.phonecall.service.iservice;

import java.util.List;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.phonecall.pojo.department.Department;

/**
 * @功能:【department 】IService
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
public interface IDepartmentService extends IBaseService<Department> {
  	/**
	 * 查询分享范围内用户
	 * @param department
	 */
	public List<Department> getShareAbleUserListPro(Department departement);
}
