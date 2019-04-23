package com.meorient.controller;

import com.meorient.SessionManager;
import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.pojo.ResponseData;
import com.meorient.pojo.Department;
import com.meorient.pojo.User;
import com.meorient.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */
@RestController
public class DepartmentController {
    /** 日志对象 */
    protected Logger logger = LogManager.getLogger(this.getClass());

    /** 部门service*/
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/api/departments/v1",method = RequestMethod.GET)
    public ResponseData getDepartmentList(Department department, HttpServletRequest request){
        User user = SessionManager.getCurrentUser(request);
        department.setId(user.getDepartmentId());
        List<Department> resultList = departmentService.getDepartmentList(department);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,resultList);
    }

    @RequestMapping(value = "/api/department/v1",method = RequestMethod.GET)
    public ResponseData getDepartment(Department department, HttpServletRequest request){
        User user = SessionManager.getCurrentUser(request);
        department.setId(user.getDepartmentId());
        Department result = departmentService.getDepartmentInfo(department);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,result);
    }

    @RequestMapping(value = "/api/department/v1",method = RequestMethod.PUT)
    public ResponseData insertDepartment(Department department){
        int result = departmentService.insertDepartment(department);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,result);
    }

    @RequestMapping(value = "/api/departments/v1",method = RequestMethod.PUT)
    public ResponseData insertDepartmentList(List<Department> departments){
        int result = departmentService.insertDepartmentList(departments);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,result);
    }

    @RequestMapping(value = "/api/department/v1",method = RequestMethod.POST)
    public ResponseData updateDepartment(Department department){
        int result = departmentService.updateDepartment(department);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,result);
    }

    @RequestMapping(value = "/api/departments/v1",method = RequestMethod.POST)
    public ResponseData updateDepartmentList(List<Department> department){
        int result = departmentService.updateDepartmentList(department);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,result);
    }
}
