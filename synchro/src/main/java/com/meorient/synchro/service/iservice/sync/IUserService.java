/** */
package com.meorient.synchro.service.iservice.sync;

import java.sql.Timestamp;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.synchro.pojo.ns.NSUser;
import com.meorient.synchro.pojo.sync.User;

/**
 * @功能:【user 】IService
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:21:54
 * @说明：<pre></pre>
 */
public interface IUserService extends IBaseService<User> {
	/**
	 * avaya ns用户增量同步
	 * @param nsDepartment
	 * @return
	 */
	public int nsAddSync(NSUser nsUser,Timestamp now);
	
	/**
	 * avaya ns用户修改同步
	 * @param nsDepartment
	 * @return
	 */
	public int nsModSync(NSUser nsUser,Timestamp now);
	
	/**
	 * avaya ns用户修正上属部门id为主键id
	 * @param nsDepartment
	 * @return
	 */
	public void nsFixSync(User user);
	
	/**
	 * 检查是否需要同步
	 * @param nsDepartment
	 * @return
	 */
	public boolean checkSync(NSUser nsUser,User user);
}
