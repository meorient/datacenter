/** */
package com.meorient.synchro.service.sync;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meorient.common.util.JsonTool;
import com.meorient.synchro.dao.sync.DepartmentDao;
import com.meorient.synchro.pojo.ns.NSDepartment;
import com.meorient.synchro.pojo.sync.Department;
import com.meorient.synchro.service.BaseService;
import com.meorient.synchro.service.iservice.sync.IDepartmentService;
import com.meorient.synchro.service.iservice.sync.ISynchroLogService;

/**
 * @功能:【department 】Service
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
@Service
public class DepartmentService extends BaseService<Department, DepartmentDao> implements IDepartmentService {
	
	/** 同步LogService*/
	@Autowired
	private ISynchroLogService synchroLogService;
	
	/**
	 * avaya ns部门增量同步
	 * @param nsDepartment
	 * @return
	 */
	@Override
	public int nsAddSync(NSDepartment nsDepartment , Timestamp now) {
		int result = -1;
		try {
			Department department = new Department();
			department.setName(nsDepartment.getName());
			department.setCreateTime(now);
			department.setParentId(nsDepartment.getParent_Id()==null?null:-nsDepartment.getParent_Id());// 负数表示未修正，非本项目上属关系
			department.setUid(nsDepartment.getDepartment_Id().toString());
			result = this.dao.insert(department);
			synchroLogService.insertDepartment("Netsuite", department, result);
		} catch (Exception e) {
			logger.error("部门增量单条同步异常，源数据信息："+ JsonTool.getString(nsDepartment) , e);
		}
		return result;
	}
	
	/**
	 * avaya ns部门修改同步
	 * @param nsDepartment
	 * @return
	 */
	@Override
	public int nsModSync(NSDepartment nsDepartment,Timestamp now) {
		int result = -1;
		try {
			Department department = new Department();
			department.setName(nsDepartment.getName());
			department.setParentId(nsDepartment.getParent_Id());
			department.setUid(nsDepartment.getDepartment_Id().toString());
			department.setCreateTime(nsDepartment.getCreateTime());
			result =  this.dao.update(department);
			synchroLogService.insertDepartment("Netsuite_add", department, result);
		} catch (Exception e) {
			logger.error("部门修改单条同步异常，源数据信息："+ JsonTool.getString(nsDepartment) , e);
		}
		return result;
	}
	
	/**
	 * 检查是否需要同步
	 * @param nsDepartment
	 * @return
	 */
	public boolean checkSync(NSDepartment nsDepartment,Department department) {
		try {
			if(!nsDepartment.getName().trim().equals(department.getName())) {
				return true;
			}
			if(!nsDepartment.getDepartment_Id().toString().trim().equals(department.getUid())) {
				return true;
			}
		}catch(Exception e) {
			logger.error("检测同步时发生异常",e);
		}
		return false;
	}

	/**
	 * avaya ns部门修正上属部门id为主键id
	 * @param nsDepartment
	 * @return
	 */
	@Override
	public void nsFixSync(Department department) {
		try {
			this.dao.fixParentId(department);
		} catch (Exception e) {
			logger.error("修正上属部门id异常" , e);
		}
	}
}
