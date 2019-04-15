/** */
package com.meorient.synchro.service.sync;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meorient.common.util.JsonTool;
import com.meorient.synchro.dao.sync.UserDao;
import com.meorient.synchro.pojo.ns.NSUser;
import com.meorient.synchro.pojo.sync.User;
import com.meorient.synchro.service.BaseService;
import com.meorient.synchro.service.iservice.sync.ISynchroLogService;
import com.meorient.synchro.service.iservice.sync.IUserService;

/**
 * @功能:【用户】Service
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:21:54
 * @说明：<pre></pre>
 */
@Service
public class UserService extends BaseService<User, UserDao> implements IUserService {
	
	/** 同步日志Service*/
	@Autowired
	private ISynchroLogService synchroLogService;

	/**
	 * avaya ns用户增量同步
	 * @param nsuser
	 * @return
	 */
	@Override
	public int nsAddSync(NSUser nsUser, Timestamp now) {
		int result = -1;
		try {
			User user = new User();
			user.setName(nsUser.getName());
			user.setCreateTime(now);
			user.setDepartmentId(nsUser.getDepartment_id()==null?null:-nsUser.getDepartment_id());// 负数表示未修正，非本项目上属关系
			user.setUid(nsUser.getEmployee_id().toString());
			user.setEmail(nsUser.getEmail());
			result = this.dao.insert(user);
			synchroLogService.insertUser("Netsuite_add", user, result);
		} catch (Exception e) {
			logger.error("用户增量单条同步异常，源数据信息："+ JsonTool.getString(nsUser) , e);
		}
		return result;
	}

	/**
	 * avaya ns用户修改同步
	 * @param nsuser
	 * @return
	 */
	@Override
	public int nsModSync(NSUser nsUser, Timestamp now) {
		int result = -1;
		try {
			User user = new User();
			user.setName(nsUser.getName());
			user.setUid(nsUser.getEmployee_id().toString());
			user.setEmail(nsUser.getEmail());
			user.setCreateTime(now);
			result =  this.dao.update(user);
			synchroLogService.insertUser("Netsuite_update", user, result);
		} catch (Exception e) {
			logger.error("用户修改单条同步异常，源数据信息："+ JsonTool.getString(nsUser) , e);
		}
		return result;
	}

	/**
	 * avaya ns用户修正上属部门id为主键id
	 * @param nsuser
	 * @return
	 */
	@Override
	public void nsFixSync(User user) {
		try {
			this.dao.fixDepartmentId(user);
		} catch (Exception e) {
			logger.error("修正部门id异常" , e);
		}
	}
	
	/**
	 * 检查是否需要同步
	 * @param nsuser
	 * @return
	 */
	public boolean checkSync(NSUser nsuser,User user) {
		try {
			if(!nsuser.getName().trim().equals(user.getName())) {
				return true;
			}
			if(!nsuser.getEmail().trim().equals(user.getEmail())) {
				return true;
			}
		}catch(Exception e) {
			logger.error("检测同步时发生异常",e);
		}
		return false;
	}
}
