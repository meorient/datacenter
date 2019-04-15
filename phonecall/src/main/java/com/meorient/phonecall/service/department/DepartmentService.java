/** */
package com.meorient.phonecall.service.department;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meorient.phonecall.dao.department.DepartmentDao;
import com.meorient.phonecall.pojo.department.Department;
import com.meorient.phonecall.service.base.BaseService;
import com.meorient.phonecall.service.iservice.IDepartmentService;

/**
 * @功能:【department 】Service
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
@Service
public class DepartmentService extends BaseService<Department, DepartmentDao> implements IDepartmentService {
  	/**
	 * 查询分享范围内用户
	 * @param department
	 */
	@Override
	public List<Department> getShareAbleUserListPro(Department department) {
		return this.dao.getShareAbleUserList(department);
	}
}
