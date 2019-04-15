package com.meorient.phonecall.service.iservice;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.pojo.wechat.Wechat;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日下午4:19:47
 */
public interface IWechatService  extends IBaseService<Wechat> {
		/**
		 * 获取企业微信accessToken
		 * @param wechat
		 * @return
		 */
		public Wechat getAccessToken(Wechat wechat);
		
		/**
		 * 获取企业微信通讯录accessToken
		 * @param wechat
		 * @return
		 */
		public Wechat getContactAccessToken(Wechat wechat);
		
		/**
		 * 获取企业微信唯一UserId
		 * @param wechat
		 * @return
		 */
		public String getUserId(User user);
		
		/**
		 * 获取企业微信用户信息
		 * @param wechat
		 * @return
		 */
		public Wechat getUserInfo(String userId);
}
