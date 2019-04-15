package com.meorient.synchro.service.ns;

import org.springframework.stereotype.Service;

import com.meorient.synchro.dao.ns.NSDepartmentDao;
import com.meorient.synchro.pojo.ns.NSDepartment;
import com.meorient.synchro.service.BaseService;
import com.meorient.synchro.service.iservice.ns.INSDepartmentService;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年4月3日上午9:59:15
 */
@Service
public class NSDepartmentService extends BaseService<NSDepartment,NSDepartmentDao> implements INSDepartmentService{
}
