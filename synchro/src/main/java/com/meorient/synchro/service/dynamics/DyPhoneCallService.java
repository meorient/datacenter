
package com.meorient.synchro.service.dynamics;

import org.springframework.stereotype.Service;

import com.meorient.synchro.dao.dynamics.DyPhoneCallDao;
import com.meorient.synchro.pojo.dynamics.DyPhoneCall;
import com.meorient.synchro.service.BaseService;
import com.meorient.synchro.service.iservice.dynamics.IDyPhoneCallService;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午8:36:16
 */
@Service
public class DyPhoneCallService extends BaseService<DyPhoneCall,DyPhoneCallDao> implements IDyPhoneCallService{
}
