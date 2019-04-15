/** */
package com.meorient.common.enumeration;

import java.util.Map;
import java.util.TreeMap;

/**
 * @功能: redis缓存
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:07:11
 */
public enum ERedisCacheKeys {
	// 区块:当前user的数据
	BLOCK_CURR_USER_DATA("{currentUserKey}", "当前user的数据区块"),
	// 区块:缓存的数据
	BLOCK_CACHE_KEY_DATA("{sysData}", "缓存的数据区块"),

	// 当前用户key
	CURRENT_USER_PREKEY("currentUser_","当前登录用户"),
	// 重复登录用户的key的前缀
	REPEAT_USER_LOGIN_PREKEY("repeatUserLoginToken_", "重复登录用户的key的前缀"),
	// 客户密码输错次数KEY
	USER_LOGIN_ERROR_TIMES_KEY("userLoginErrorTimesKy_", "客户密码输错次数KEY "),
	// 客户信息参数缓存
	USER_INFO_CACHE("userInfoCache", "使用图形验证码时保存用户信息"),

	// 资源最新版本key
	KEY_RESOURCE_NEW_VER("resourceNewVer", "图片资源最新版本"),
	// 系统验证信息NewVer
	KEY_SYS_AUTHINFO_NEW_VER("sysAuthinfoNewVer", "系统验证信息NewVer"),
	// 银行卡信息newver
	KEY_SYSBANK_NEW_VER("sysBankNewVer", "银行卡信息newver"),
	// 省市区县行政地区信息NewVer
	KEY_SYS_REGION_NEW_VER("sysRegionNewVer", "省市区县行政地区信息NewVer");
	
	// 状态编号
	private String code;
	// 状态名称
	private String name;
	// 所有状态
	private static Map<Object, EnumProperty> statusMap;

	/**
	 * 得到所有状态
	 * 
	 * @return
	 */
	public static Map<Object, EnumProperty> getStatusMap() {
		if (statusMap == null) {
			Map<Object, EnumProperty> map = new TreeMap<Object, EnumProperty>();
			EnumProperty temp = null;
			ERedisCacheKeys[] vals = ERedisCacheKeys.values();
			for (ERedisCacheKeys val : vals) {
				temp = new EnumProperty(val.code, val.name, val.name);
				map.put(val.code, temp);
			}
			statusMap = map;
		}
		return statusMap;
	}

	/**
	 * 根据状态值取得对应状态信息
	 * 
	 * @param key
	 * @return
	 */
	public static EnumProperty getStatusByVal(Object key) {
		return getStatusMap().get(key);
	}

	/**
	 * 构造函数
	 *
	 * @param code
	 * @param name
	 */
	private ERedisCacheKeys(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/** @取得 状态编号 */
	public String getCode() {
		return code;
	}

	/** @取得 状态名称 */
	public String getName() {
		return name;
	}

}
