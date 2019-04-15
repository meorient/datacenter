/** */
package com.meorient.synchro.service.iservice.sync;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.synchro.pojo.sync.Department;
import com.meorient.synchro.pojo.sync.PhoneCall;
import com.meorient.synchro.pojo.sync.SynchroLog;
import com.meorient.synchro.pojo.sync.User;

/**
 * @功能:【department 】IService
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
public interface ISynchroLogService extends IBaseService<SynchroLog> {
	/**
	 * 添加部门同步日志
	 * @param department
	 * @return
	 */
	public int insertDepartment(String source , Department department, int result);
	
	/**
	 * 添加用户同步日志
	 * @param department
	 * @return
	 */
	public int insertUser(String source , User user, int result);
	
	/**
	 * 添加部门同步日志
	 * @param department
	 * @return
	 */
	public int insertPhoneCall(String source , PhoneCall phoneCall, int result);
}
