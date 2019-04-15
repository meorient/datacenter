
package com.meorient.synchro.service.sync;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meorient.synchro.dao.sync.PhoneCallDao;
import com.meorient.synchro.pojo.dynamics.DyPhoneCall;
import com.meorient.synchro.pojo.sync.PhoneCall;
import com.meorient.synchro.service.BaseService;
import com.meorient.synchro.service.iservice.sync.IPhoneCallService;
import com.meorient.synchro.service.iservice.sync.ISynchroLogService;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午8:36:16
 */
@Service
public class PhoneCallService extends BaseService<PhoneCall,PhoneCallDao> implements IPhoneCallService{
	
	@Autowired
	private ISynchroLogService synchroLogService;
	
	/**
	 * 同步dynamics电话记录
	 * @param pc
	 * @param dypc
	 */
	@Override
	public int dyAddSync(DyPhoneCall dypc , Timestamp now) {
		int result = -1;
		try {
			PhoneCall pc = new PhoneCall();
			pc.setRecordText(dypc.getDescription());
			pc.setCallTime(dypc.getNew_begintime());
			pc.setConnectTime(dypc.getNew_connectTime());
			pc.setDisconnectTime(dypc.getNew_dialtime());
			pc.setRecordUrl(dypc.getNew_recordlink());
			pc.setFromTel(dypc.getNew_fromnum());
			pc.setToTel(dypc.getNew_tonum());
			pc.setUserName(dypc.getOwnerIdName());
			pc.setCreateTime(now);
			result = this.dao.insert(pc);
			synchroLogService.insertPhoneCall("dynamics_add", pc, result);
		} catch (Exception e) {
			logger.error("添加单条电话记录异常",e);
		}
		return result;
	}
	
	/**
	 * 修正userId为系统内主键id
	 * @param nsDepartment
	 * @return
	 */
	@Override
	public void dyFixSync(PhoneCall pc) {
		try {
			this.dao.fixUserId(pc);
			this.dao.fixDuplicated(pc);
		} catch (Exception e) {
			logger.error("修正userid或重名异常" , e);
		}
	}
}
