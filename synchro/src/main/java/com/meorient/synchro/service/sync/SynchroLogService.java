/** */
package com.meorient.synchro.service.sync;

import org.springframework.stereotype.Service;

import com.meorient.common.util.JsonTool;
import com.meorient.synchro.dao.sync.SynchroLogDao;
import com.meorient.synchro.pojo.sync.Department;
import com.meorient.synchro.pojo.sync.PhoneCall;
import com.meorient.synchro.pojo.sync.SynchroLog;
import com.meorient.synchro.pojo.sync.User;
import com.meorient.synchro.service.BaseService;
import com.meorient.synchro.service.iservice.sync.ISynchroLogService;

/**
 * @功能:【department 】Service
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:16:39
 * @说明：<pre></pre>
 */
@Service
public class SynchroLogService extends BaseService<SynchroLog, SynchroLogDao> implements ISynchroLogService {
	/**
	 * 添加部门同步日志
	 * @param department
	 * @return
	 */
	@Override
	public int insertDepartment(String source , Department department, int result) {
		try{
			SynchroLog log = new SynchroLog();
			log.setSource(source);
			log.setContent(JsonTool.getString(department));
			log.setCreateTime(department.getCreateTime());
			log.setTableName("department");
			log.setResult(result);
			return this.dao.insert(log);
		} catch (Exception e) {
			logger.error("添加部门同步log异常",e);
		}
		return 0;
	}
	
	/**
	 * 添加部门同步日志
	 * @param department
	 * @return
	 */
	@Override
	public int insertUser(String source , User user, int result) {
		try{
			SynchroLog log = new SynchroLog();
			log.setSource(source);
			log.setContent(JsonTool.getString(user));
			log.setCreateTime(user.getCreateTime());
			log.setTableName("user");
			log.setResult(result);
			return this.dao.insert(log);
		} catch (Exception e) {
			logger.error("添加用户同步log异常",e);
		}
		return 0;
	}
	
	
	/**
	 * 添加部门同步日志
	 * @param department
	 * @return
	 */
	public int insertPhoneCall(String source , PhoneCall phoneCall, int result) {
		try{
			SynchroLog log = new SynchroLog();
			log.setSource(source);
			log.setContent(JsonTool.getString(phoneCall));
			log.setCreateTime(phoneCall.getCreateTime());
			log.setTableName("phonecall");
			log.setResult(result);
			return this.dao.insert(log);
		} catch (Exception e) {
			logger.error("添加电话记录同步log异常",e);
		}
		return 0;
	}
}
