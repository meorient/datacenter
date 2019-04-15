/** */
package com.meorient.phonecall.service.iservice;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.phonecall.pojo.user.User;

/**
 * @功能:【user 】IService
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:21:54
 * @说明：<pre></pre>
 */
public interface IUserService extends IBaseService<User> {
	/**
	 * 根据企业微信code校对本地用户登录
	 * @param user
	 * @return
	 */
	public User updateEWechatLogin(User user);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user);
}
