package com.meorient.dao;

import com.meorient.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */
@Repository
public class DepartmentDao extends BaseDao<Department> {

    /**
     * 查询部门列表
     * @param department
     * @return
     */
    public List<Department> selectDepartmentList(Department department){
        return this.selectList(department);
    }

    /**
     * 查询部门信息
     * @param department
     * @return
     */
    public Department selectDepartmentInfo(Department department){
        return this.selectUnique(department);
    }

    /**
     * 插入部门信息
     * @param department
     * @return
     */
    public int insertDepartment(Department department){
        return this.insert(department);
    }

    /**
     * 批量插入部门信息
     * @param departmentList
     * @return
     */
    public int insertDepartmentList(List<Department> departmentList){
        return this.insertList(departmentList);
    }

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    public int updateDepartment(Department department){
        return this.update(department);
    }

    /**
     * 批量更新部门信息
     * @param departmentList
     * @return
     */
    public int updateDepartmentList(List<Department> departmentList){
        return this.updateList(departmentList);
    }

}
