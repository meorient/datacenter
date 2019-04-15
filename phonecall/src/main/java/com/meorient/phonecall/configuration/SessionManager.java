/**
 * 
 */
package com.meorient.phonecall.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.meorient.common.configuration.CfgResAndSessionParam;
import com.meorient.common.database.redis.BaseRedisDao;
import com.meorient.common.enumeration.ERedisCacheKeys;
import com.meorient.phonecall.pojo.user.User;

/**
 * @功能: 会话管理
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月20日下午2:02:30
 */
@Component
public class SessionManager {
	/** 日志对象 */
	protected static Logger logger = LogManager.getLogger(SessionManager.class);
	
	/** redisDao基类 */
	private static BaseRedisDao baseRedisDao;
	
	/** 系统会话参数配置 */
	private static CfgResAndSessionParam cfgResAndSessionParam;

	/**
	 * 根据request取得用户的登录token
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserLoginToken(HttpServletRequest request) {
		String userToken = request.getHeader("X-UserToken");
		if (StringUtils.isEmpty(userToken)) {
			userToken = request.getParameter("X-UserToken");
		}
		return userToken;
	}

	/**
	 * 取得当前用户会话,同时延长会话时间
	 * 
	 * @param request
	 * @return
	 */
	public static User getCurrentUser(HttpServletRequest request) {
		String token = getUserLoginToken(request);
		if (token == null) {
			return null;
		}
		return getCurrentUser(token);
	}

	/**
	 * 根据userId取得用户登录的Token
	 * 
	 * @param userId
	 * @return
	 */
	public static String getUserLoginToken(Long userId) {
		return baseRedisDao.get(ERedisCacheKeys.CURRENT_USER_PREKEY.getCode() + userId
				+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode(), String.class);
	}

	/**
	 * 取得当前用户会话,同时延长会话时间
	 * 
	 * @param token
	 * @return
	 */
	public static User getCurrentUser(String token) {
		User user = baseRedisDao.get(ERedisCacheKeys.CURRENT_USER_PREKEY.getCode() + token
				+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode(), User.class,
				cfgResAndSessionParam.getSessionExp() * 60);

		// 同时延长会话时间
		if (user != null) {
			baseRedisDao
					.saveOrUpdate(ERedisCacheKeys.CURRENT_USER_PREKEY.getCode() + user.getId()
							+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode(), token,
							cfgResAndSessionParam.getSessionExp() * 60);
		}
		return user;
	}	

	/**
	 * 设置用户登录错误次数
	 * 
	 * @param userId 用户ID
	 * @return
	 */
	public static long setLoginErrorTimes(Long userId) {
		LocalDate now = LocalDate.now();
		String key = ERedisCacheKeys.USER_LOGIN_ERROR_TIMES_KEY.getCode() + now.toString() + "_" + userId;
		Integer errorTimes = baseRedisDao.get(key, Integer.class);
		if (errorTimes == null) {
			now = now.plusDays(1);
			LocalDateTime nowTime = LocalDateTime.of(now, LocalTime.of(0, 0, 0));
			Long exporeTimes = nowTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
					- System.currentTimeMillis();
			errorTimes = 1;
			return baseRedisDao.saveOrUpdate(key, errorTimes, Integer.parseInt(exporeTimes.toString()));
		} else {
			errorTimes++;
			return baseRedisDao.saveOrUpdate(key, errorTimes);
		}
	}

	/**
	 * 取得用户登录错误次数
	 * 
	 * @param userId 用户ID
	 * @return
	 */
	public static Integer getUserLoginErrorTimes(Long userId) {
		LocalDate now = LocalDate.now();
		String key = ERedisCacheKeys.USER_LOGIN_ERROR_TIMES_KEY.getCode() + now.toString() + "_" + userId;
		Integer result = baseRedisDao.get(key, Integer.class);
		return result == null ? 0 : result;
	}

	/**
	 * 设置当前登录用户会话,同时设置会话时间
	 *
	 * @param user
	 * @return
	 */
	public static long setCurrentUser(String token, User user) {
		// redis存储：currentCustKey_userId,token,用于判断当前用户是否登录
		baseRedisDao.saveOrUpdate(ERedisCacheKeys.CURRENT_USER_PREKEY.getCode() + user.getId()
				+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode(), token, cfgResAndSessionParam.getSessionExp() * 60);
		// redis存储：currentCustKey_token,user,用于根据token取得用户信息
		return baseRedisDao.saveOrUpdate(ERedisCacheKeys.CURRENT_USER_PREKEY.getCode() + token
				+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode(), user, cfgResAndSessionParam.getSessionExp() * 60);
	}

	/**
	 * 移除当前登录用户：用于用户重复登录或注销
	 * 
	 * @param userId
	 * @return
	 */
	public static boolean removeCurrentUser(Long userId) {
		String token = getUserLoginToken(userId);
		if (token != null) {
			baseRedisDao.delete(ERedisCacheKeys.CURRENT_USER_PREKEY.getCode() + userId
					+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode());
			baseRedisDao.delete(ERedisCacheKeys.CURRENT_USER_PREKEY.getCode() + token
					+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode());
			return true;
		}
		return false;
	}

	/**
	 * 当用户重复登录时，将前一个token保存到另一个对象，下次访问时提示您已在另一处登录
	 * 
	 * @param token
	 * @param val
	 * @return
	 */
	public static long setRepeatUserLoginToken(String token) {
		return baseRedisDao.saveOrUpdate(ERedisCacheKeys.REPEAT_USER_LOGIN_PREKEY.getCode() + token
				+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode(), true, cfgResAndSessionParam.getSessionExp() * 60);
	}

	/**
	 * 当用户重复登录时，将前一个token保存到另一个对象，下次访问时提示您已在另一处登录
	 * 
	 * @param token
	 * @return
	 */
	public static String getRepeatUserLoginToken(String token) {
		String repeatToken = baseRedisDao.get(ERedisCacheKeys.REPEAT_USER_LOGIN_PREKEY.getCode() + token
				+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode(), String.class);
		if (repeatToken != null) {
			baseRedisDao.delete(ERedisCacheKeys.REPEAT_USER_LOGIN_PREKEY.getCode() + token
					+ ERedisCacheKeys.BLOCK_CURR_USER_DATA.getCode());
		}
		return repeatToken;
	}

	@Autowired
	public void setCfgResAndSessionParam(CfgResAndSessionParam cfgResAndSessionParam) {
		SessionManager.cfgResAndSessionParam = cfgResAndSessionParam;
	}

	@Autowired
	@Qualifier("baseRedisDaoDef")
	public void setBaseRedisDao(BaseRedisDao baseRedisDao) {
		SessionManager.baseRedisDao = baseRedisDao;
	}
}
