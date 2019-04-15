package com.meorient.synchro.service.iservice.sync;

import java.sql.Timestamp;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.synchro.pojo.dynamics.DyPhoneCall;
import com.meorient.synchro.pojo.sync.PhoneCall;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午8:36:24
 */
public interface IPhoneCallService extends IBaseService<PhoneCall>{
	/**
	 * 同步dynamics电话记录
	 * @param pc
	 * @param dypc
	 */
	public int dyAddSync(DyPhoneCall dypc , Timestamp now);
	
	/**
	 * 修正userId为系统内主键id
	 * @param nsDepartment
	 * @return
	 */
	public void dyFixSync(PhoneCall pc);
}
