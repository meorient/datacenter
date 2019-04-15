/** */
package com.meorient.synchro.dao.sync;

import org.springframework.stereotype.Repository;

import com.meorient.synchro.dao.BaseMysqlDao;
import com.meorient.synchro.pojo.sync.User;

/**
 * @功能:【user 】Dao
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:21:54
 * @说明：<pre></pre>
 */
@Repository
public class UserDao extends BaseMysqlDao<User> {
	/**
	 * avaya ns用户修正部门id为主键id
	 * @param department
	 * @return
	 */
	public int fixDepartmentId(User user) {
		return this.update("fixDepartmentId", user);
	}
}
