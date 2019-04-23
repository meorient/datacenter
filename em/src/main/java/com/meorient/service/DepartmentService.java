package com.meorient.service;

import com.meorient.dao.DepartmentDao;
import com.meorient.pojo.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */

@Service
public class DepartmentService extends BaseService<Department, DepartmentDao> {


    /**
     * 获取部门列表
     * @param department
     * @return
     */
    public List<Department> getDepartmentList(Department department){
        return this.dao.selectDepartmentList(department);
    }

    /**
     * 获取部门信息
     * @param department
     * @return
     */
    public Department getDepartmentInfo(Department department){
        return this.dao.selectDepartmentInfo(department);
    }

    /**
     * 插入部门信息
     * @param department
     * @return
     */
    public int insertDepartment(Department department){
        return this.dao.insertDepartment(department);
    }

    /**
     * 批量插入部门信息
     * @param departmentList
     * @return
     */
    public int insertDepartmentList(List<Department> departmentList){
        return this.dao.insertDepartmentList(departmentList);
    }

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    public int updateDepartment(Department department){
        return this.dao.updateDepartment(department);
    }

    /**
     * 批量更新部门信息
     * @param departmentList
     * @return
     */
    public int updateDepartmentList(List<Department> departmentList){
        return this.dao.updateDepartmentList(departmentList);
    }
}
