package com.meorient.phonecall.service.sysauthinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.database.redis.BaseRedisDao;
import com.meorient.common.enumeration.ERedisCacheKeys;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.util.StringTool;
import com.meorient.phonecall.dao.sysauthinfo.SysAuthInfoDao;
import com.meorient.phonecall.pojo.sysauthinfo.SysAuthInfo;
import com.meorient.phonecall.service.base.BaseCacheService;
import com.meorient.phonecall.service.iservice.ISysAuthInfoService;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月20日下午2:42:21
 */
@Service
public class SysAuthInfoService extends BaseCacheService<SysAuthInfo, SysAuthInfoDao> implements
		ISysAuthInfoService {

	/** redis操作dao */
	@Autowired
	@Qualifier("baseRedisDaoDef") 
	private BaseRedisDao baseRedisDao;
	/** 认证超时限制（单位：分钟） */
	private int authValidTime = 10;
	/** 认证信息最新版本 */
	private Long authInfoLastVer;
	/** 认证信息map */
	public Map<String, SysAuthInfo> sysAuthInfoMap;
 
	/**
	 * 
	 */
	@Override
	@PostConstruct
	protected void init() {
		Long lastVer = baseRedisDao.get(ERedisCacheKeys.KEY_SYS_AUTHINFO_NEW_VER.getCode(), Long.class);
		if (lastVer == null) {
			lastVer = System.currentTimeMillis();
			baseRedisDao.saveOrUpdate(ERedisCacheKeys.KEY_SYS_AUTHINFO_NEW_VER.getCode(), lastVer);// 更新新版本为当前
		}
		if (authInfoLastVer == null || authInfoLastVer < lastVer) {
			logger.info("====================开始加载AuthInfo信息=====================");
			authInfoLastVer = lastVer;// 记录图片资源对应版本号。
			Map<String, SysAuthInfo> map = new HashMap<String, SysAuthInfo>();
			List<SysAuthInfo> sysAuthInfoList = this.selectList(new SysAuthInfo());
			for (SysAuthInfo authInfo : sysAuthInfoList) {
				map.put(authInfo.getAccount(), authInfo);
			}
			sysAuthInfoMap = map;
			logger.info("加载AuthInfo完成！lastVer:" + lastVer);
		}
	}

	/**
	 * @param sysAuthInfoPojo
	 */
	@Override
	public void cleanCache(SysAuthInfo sysAuthInfoPojo) {
		Long newVer = System.currentTimeMillis();
		baseRedisDao.saveOrUpdate(ERedisCacheKeys.KEY_SYS_AUTHINFO_NEW_VER.getCode(), newVer);// 更新新版本为当前
	}

	/**
	 * @param sysAuthInfoPojo
	 * @return
	 */
	@Override
	public SysAuthInfo getCacheDataByKey(SysAuthInfo sysAuthInfoPojo) {
		Assert.notNull(sysAuthInfoPojo.getAccount(), "authInfo账号不能为空");
		init();
		return sysAuthInfoMap.get(sysAuthInfoPojo.getAccount());
	}

	/**
	 * @param account
	 * @param timestamp
	 * @param sign
	 * @param authInfoType
	 * @return
	 */
	@Override
	public OptResult chenkSign(String account, String timestamp, String sign) {
		// 检查参数
		if (StringUtils.isEmpty(account)) {
			return EMsgCommon.exptSystemException.getOptResult(logger, "authInfo账号不能为空。");
		}
		if (StringUtils.isEmpty(timestamp) || !timestamp.matches("^[1-9][0-9]*$")) {
			return EMsgCommon.exptSystemException.getOptResult(logger, "authInfo请求时间戳不能为空或格式不正确。");
		}
		if (StringUtils.isEmpty(sign)) {
			return EMsgCommon.exptSystemException.getOptResult(logger, "authInfo签名不能为空。");
		}

		Long signTime = Long.parseLong(timestamp);
		Long s = System.currentTimeMillis() - signTime;
		if (Math.abs(s) > authValidTime * 60000) {
			return EMsgCommon.svceErrSysAuthInfoTimeOut.getOptResult(logger, "authInfo签名超过" + authValidTime
					+ "分钟,实际：" + (s / 1000) + "秒");
		}

		// 检查账号信息
		SysAuthInfo sysAuthInfoPojo = new SysAuthInfo();
		sysAuthInfoPojo.setAccount(account);
		sysAuthInfoPojo = getCacheDataByKey(sysAuthInfoPojo);
		if (sysAuthInfoPojo == null) {
			return EMsgCommon.exptSystemException.getOptResult(logger, "authInfo账号无效");
		}

		String newSign = StringTool.MD5Encode(account + timestamp + sysAuthInfoPojo.getSecret());
		if (newSign.equals(sign)) {
			return EMsgCommon.svceRigOptSuccess.getOptResult(logger, "authInfo认证通过");
		}
		return EMsgCommon.svceErrSysAuthInfoTimeOut.getOptResult(logger, "authInfo签名无效");
	}

}
