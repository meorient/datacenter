package com.meorient.synchro.dao.sync;

import org.springframework.stereotype.Repository;

import com.meorient.synchro.dao.BaseMysqlDao;
import com.meorient.synchro.pojo.sync.PhoneCall;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午9:09:40
 */
@Repository
public class PhoneCallDao extends BaseMysqlDao<PhoneCall>{
	/**
	 * 修正userId为系统内主键id
	 * @param nsDepartment
	 * @return
	 */
	public int fixUserId(PhoneCall pc) {
		return this.update("fixUserId", pc);
	}
	
	/**
	 * 修正重复名称问题
	 * @param nsDepartment
	 * @return
	 */
	public int fixDuplicated(PhoneCall pc) {
		return this.update("fixDuplicated", pc);
	}
}
