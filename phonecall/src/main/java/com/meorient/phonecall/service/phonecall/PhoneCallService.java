
package com.meorient.phonecall.service.phonecall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meorient.phonecall.dao.phonecall.PhoneCallDao;
import com.meorient.phonecall.pojo.phonecall.PhoneCall;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.service.base.BaseService;
import com.meorient.phonecall.service.iservice.IPhoneCallService;
import com.meorient.phonecall.service.iservice.IUserService;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午8:36:16
 */
@Service
public class PhoneCallService extends BaseService<PhoneCall,PhoneCallDao> implements IPhoneCallService{
	
	/** 用户Service */
	@Autowired
	private IUserService userService;
	
	/**
	 * 方法重写
	 */ 
	@Override
	public List<User> getPhoneCallList(PhoneCall pc) {
		// 根据部门查询用户
		User user = new User();
		user.setDepartmentId(pc.getDepartmentId());
		List<User> userList = userService.selectList(user);
		
		// 根据用户查询电话记录
		PhoneCall phoneCall = null;
		List<PhoneCall> pcList = null;
		List<PhoneCall> pcShareList = null;
		for(User u : userList) {
			phoneCall = new PhoneCall();
			phoneCall.setUserId(u.getId());
			phoneCall.setCallTime(pc.getCallTime());
			// 查看下属
			pcList = this.dao.selectList(phoneCall);
			u.setPhoneCallList(pcList);
			calConnectSecondsTotal(u);
			// 查看被分享记录
			pcShareList = this.dao.selectShareList(phoneCall);
			u.setPhoneCallShareList(pcShareList);
		}
		return userList; 
	}
	
	/**
	 * 计算员工拨打总时长
	 */
	private User calConnectSecondsTotal(User user) {
		List<PhoneCall> callList = user.getPhoneCallList();
		if(callList == null || callList.isEmpty()) {
			return user;
		}
		int time = 0;
		for( PhoneCall pc : callList ) {
			if(pc.getConnectSeconds() != null) {
				time += pc.getConnectSeconds();
			}
		}
		user.setConnectSecondsTotal(time);
		return user;
	}
}
