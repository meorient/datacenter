/** */
package com.meorient.phonecall.controller.department;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.pojo.ResponseData;
import com.meorient.phonecall.configuration.SessionManager;
import com.meorient.phonecall.pojo.department.Department;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.service.iservice.IDepartmentService;

/**
 * @功能:【department 】controller
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
@RestController
@RequestMapping("/department")
public class DepartmentController{
	/** 日志对象 */
	protected Logger logger = LogManager.getLogger(this.getClass());

	/** 部门service*/
    @Autowired
    private IDepartmentService departmentService;
    
  	/**
	 * 得到自己及下属部门
	 * @param department
	 * @param request
	 * @param response
	 */
	@RequestMapping("/api/getDepartmentListPro/v1")
	public ResponseData getDepartmentList(Department department, HttpServletRequest request, HttpServletResponse response) {
		User user = SessionManager.getCurrentUser(request); 
		department.setId(user.getDepartmentId());
		List<Department> resultList = departmentService.selectList(department);
		OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
		return new ResponseData(info,resultList);
	}
	
  	/**
	 * 查询可分享部门及用户
	 * @param department
	 * @param request
	 * @param response
	 */
	@RequestMapping("/api/getShareAbleUserListPro/v1")
	public ResponseData getShareAbleUserList(Department department, HttpServletRequest request, HttpServletResponse response) {
		User user = SessionManager.getCurrentUser(request); 
		department.setId(user.getDepartmentId());
		department.setUserId(user.getId());
		List<Department> resultList = departmentService.getShareAbleUserListPro(department);
		OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
		return new ResponseData(info,resultList);
	}
}
