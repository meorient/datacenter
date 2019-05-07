/** */
package com.meorient.phonecall.service.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meorient.common.util.HttpClientTool;
import com.meorient.common.util.JsonTool;
import com.meorient.common.util.StringTool;
import com.meorient.phonecall.configuration.SessionManager;
import com.meorient.phonecall.dao.user.UserDao;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.pojo.wechat.Wechat;
import com.meorient.phonecall.service.base.BaseService;
import com.meorient.phonecall.service.iservice.IUserService;
import com.meorient.phonecall.service.iservice.IWechatService;
import com.meorient.phonecall.service.temp.temp;
import com.meorient.phonecall.service.temp.temp2;

/**
 * @功能:【用户】Service
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:21:54
 * @说明：<pre></pre>
 */
@Service
public class UserService extends BaseService<User, UserDao> implements IUserService {
	
	/** 企业微信Service */
	@Autowired
	private IWechatService wechatService;
	
	/**
	 * 根据企业微信wechatUserId校对本地用户登录
	 * @param user
	 * @return
	 */
	@Override
	public User updateEWechatLogin(User user) {
		if(user.getCode()==null) {
			return null;
		}
		// 通过授权code获取UserId
		String userId = wechatService.getUserId(user);
		user.setWechatUserId(userId);
		
		// 通过wechatUserId进行校对登录
		User loginUser = login(user);
		if(loginUser!=null) {
			return loginUser;
		}
		
		// 没有匹配，初始校对，通过wechatUserId和contact_access_token得到email
		logger.info("没有匹配，初始校对，通过wechatUserId和contact_access_token得到email");
		Wechat wechat = wechatService.getUserInfo(userId);
		user.setEmail(wechat.getEmail());
		
		// 通过邮箱进行匹配并记录wechatUserId之后进行登录
		int update = this.dao.update(user);
		if(update==1) {
			//成功绑定，登录返回
			loginUser = login(user);
			logger.info("");
		}
		return loginUser;
	}

	/**
	 * 用户登录
	 * @方法重写
	 */
	@Override
	public User login(User user) {
		// 查找唯一用户
		User loginUser = this.dao.selectUnique(user);
		if(loginUser==null) {
			return null;
		}
		// 将上次登录的token标志为已重复登录
		String loginToken = SessionManager.getUserLoginToken(loginUser.getId());
		if (loginToken != null) {
			SessionManager.setRepeatUserLoginToken(loginToken);
		}
		// 生成token，保存登录信息
		loginToken = StringTool.MD5Encode(UUID.randomUUID().toString());
		SessionManager.removeCurrentUser(loginUser.getId());
		SessionManager.setCurrentUser(loginToken, loginUser);
		loginUser.setToken(loginToken);
		return loginUser;
	}
}
