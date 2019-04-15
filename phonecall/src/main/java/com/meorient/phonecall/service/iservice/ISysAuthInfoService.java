package com.meorient.phonecall.service.iservice;

import com.meorient.common.pojo.OptResult;
import com.meorient.common.service.iservice.IBaseCacheService;
import com.meorient.phonecall.pojo.sysauthinfo.SysAuthInfo;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月20日下午2:42:26
 */
public interface ISysAuthInfoService extends IBaseCacheService<SysAuthInfo, SysAuthInfo> {
	/**
	 * 验证签名是否正确
	 * 
	 * @param account
	 * @param timestamp
	 * @param sign
	 * @param authInfoType
	 * @return
	 */
	public OptResult chenkSign(String account, String timestamp, String sign);
}
