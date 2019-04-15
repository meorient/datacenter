package com.meorient.phonecall.service.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.github.pagehelper.util.StringUtil;
import com.meorient.common.database.redis.BaseRedisDao;
import com.meorient.common.util.HttpClientTool;
import com.meorient.common.util.JsonTool;
import com.meorient.phonecall.dao.wechat.WechatDao;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.pojo.wechat.Wechat;
import com.meorient.phonecall.service.base.BaseService;
import com.meorient.phonecall.service.iservice.IWechatService;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日下午6:13:18
 */
@Service
@ConfigurationProperties(prefix = "commonCfg.wechat")
public class WechatService extends BaseService<Wechat, WechatDao> implements IWechatService {
	/** corpId */
	private String corpId;

	/** 得到accessToken的Url */
	private String getAccessTokenUrl;

	/** 得到userId的Url */
	private String getUserIdUrl;

	/** 得到用户信息的Url */
	private String getUserInfoUrl;

	/** 应用token redis Key */
	private String redisTokenKey;

	/** 通讯录token redis Key */
	private String redisContactTokenKey;

	/** 应用secret */
	private String applicationSecret;

	/** 通讯录secret */
	private String contactSecret;

	/** redis */
	@Autowired
	private BaseRedisDao baseRedisDao;

	/**
	 * 方法重写
	 */
	@Override
	public Wechat getAccessToken(Wechat wechat) {
		// 查看已有token
		String accessToken = baseRedisDao.get(redisTokenKey, String.class);
		if (accessToken != null) {
			wechat.setAccess_token(accessToken);
			return wechat;
		}
		// 获取新token
		try {
			String result = HttpClientTool.get(getAccessTokenUrl + "corpid=" + corpId + "&corpsecret=" + applicationSecret);
			wechat = JsonTool.getObj(result, Wechat.class);
			if (StringUtil.isEmpty(wechat.getAccess_token())) {
				logger.error("获取access_token失败:" + wechat);
				return null;
			}
			baseRedisDao.saveOrUpdate(redisTokenKey, wechat.getAccess_token(), 7200);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return wechat;
	}

	/**
	 * 方法重写
	 */
	@Override
	public Wechat getContactAccessToken(Wechat wechat) {
		// 查看已有token
		String contactToken = baseRedisDao.get(redisContactTokenKey, String.class);
		if (contactToken != null) {
			wechat.setContact_access_token(contactToken);
			return wechat;
		}
		// 获取新token
		try {
			String result = HttpClientTool.get(getAccessTokenUrl + "corpid=" + corpId + "&corpsecret=" + contactSecret);
			wechat = JsonTool.getObj(result, Wechat.class);
			wechat.setContact_access_token(wechat.getAccess_token());
			if (StringUtil.isEmpty(wechat.getContact_access_token())) {
				logger.error("获取contact_access_token失败:" + result);
				return null;
			}
			baseRedisDao.saveOrUpdate(redisContactTokenKey, wechat.getContact_access_token(), 7200);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return wechat;
	}

	/**
	 * 获取企业微信唯一UserId
	 * 
	 * @param wechat
	 * @return
	 */
	public String getUserId(User user) {
		String result = null;
		Wechat wechat = this.getAccessToken(new Wechat());
		String access_token = wechat.getAccess_token();
		try {
			result = HttpClientTool.get(getUserIdUrl + "access_token=" + access_token + "&code=" + user.getCode());
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		wechat = JsonTool.getObj(result, Wechat.class);
		return wechat.getUserId();
	}

	/**
	 * 获取企业微信用户信息
	 * 
	 * @param wechat
	 * @return
	 */
	public Wechat getUserInfo(String userId) {
		String result = null;
		Wechat wechat = this.getContactAccessToken(new Wechat());
		String contactToken = wechat.getContact_access_token();
		try {
			result = HttpClientTool.get(getUserInfoUrl + "access_token=" + contactToken + "&userid=" + userId);
			logger.info(result);
			wechat = JsonTool.getObj(result, Wechat.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wechat;
	}

	/**
	 * @取得 getAccessTokenUrl
	 */
	public String getGetAccessTokenUrl() {
		return getAccessTokenUrl;
	}

	/**
	 * @设置 getAccessTokenUrl
	 */
	public void setGetAccessTokenUrl(String getAccessTokenUrl) {
		this.getAccessTokenUrl = getAccessTokenUrl;
	}

	/**
	 * @取得 corpId
	 */
	public String getCorpId() {
		return corpId;
	}

	/**
	 * @设置 corpId
	 */
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	/**
	 * @取得 redisTokenKey
	 */
	public String getRedisTokenKey() {
		return redisTokenKey;
	}

	/**
	 * @设置 redisTokenKey
	 */
	public void setRedisTokenKey(String redisTokenKey) {
		this.redisTokenKey = redisTokenKey;
	}

	/**
	 * @取得 baseRedisDao
	 */
	public BaseRedisDao getBaseRedisDao() {
		return baseRedisDao;
	}

	/**
	 * @设置 baseRedisDao
	 */
	public void setBaseRedisDao(BaseRedisDao baseRedisDao) {
		this.baseRedisDao = baseRedisDao;
	}

	/**
	 * @取得 getUserIdUrl
	 */
	public String getGetUserIdUrl() {
		return getUserIdUrl;
	}

	/**
	 * @设置 getUserIdUrl
	 */
	public void setGetUserIdUrl(String getUserIdUrl) {
		this.getUserIdUrl = getUserIdUrl;
	}

	/**
	 * @取得 getUserInfoUrl
	 */
	public String getGetUserInfoUrl() {
		return getUserInfoUrl;
	}

	/**
	 * @设置 getUserInfoUrl
	 */
	public void setGetUserInfoUrl(String getUserInfoUrl) {
		this.getUserInfoUrl = getUserInfoUrl;
	}

	/**
	 * @取得 redisContactTokenKey
	 */
	public String getRedisContactTokenKey() {
		return redisContactTokenKey;
	}

	/**
	 * @设置 redisContactTokenKey
	 */
	public void setRedisContactTokenKey(String redisContactTokenKey) {
		this.redisContactTokenKey = redisContactTokenKey;
	}

	/**
	 * @取得 applicationSecret
	 */
	public String getApplicationSecret() {
		return applicationSecret;
	}

	/**
	 * @设置 applicationSecret
	 */
	public void setApplicationSecret(String applicationSecret) {
		this.applicationSecret = applicationSecret;
	}

	/**
	 * @取得 contactSecret
	 */
	public String getContactSecret() {
		return contactSecret;
	}

	/**
	 * @设置 contactSecret
	 */
	public void setContactSecret(String contactSecret) {
		this.contactSecret = contactSecret;
	}
}
