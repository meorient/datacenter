package com.meorient.phonecall.service.iservice;

import java.util.List;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.phonecall.pojo.phonecall.PhoneCall;
import com.meorient.phonecall.pojo.user.User;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午8:36:24
 */
public interface IPhoneCallService extends IBaseService<PhoneCall>{
	/**
	 * 根据登录者权限查看下属电话记录信息
	 * @param pc
	 * @return
	 */
	public List<User> getPhoneCallList(PhoneCall pc);
}
