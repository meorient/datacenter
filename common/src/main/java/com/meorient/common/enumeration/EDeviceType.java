/** */
package com.meorient.common.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @功能:  设备类型
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:07:11
 */
public enum EDeviceType {
	/** 全部 */
	All(0, "全部"),
	/** 安卓操作系统设备 */
	Android(1, "ANDROID"),
	/** IOS操作系统设备 */
	IOS(2, "IOS"),
	/** 除android和IOS系统的设备 */
	PC(3, "PC"),
	/** 微信小程序 */
	WXAPPLET(4, "微信小程序");

	/** 设备类型val */
	private Integer val;
	/** 设备类型name */
	private String name;

	/** 所有状态 */
	private static Map<Object, EnumProperty> statusMap;

	/**
	 * 得到所有状态
	 *
	 * @return
	 */
	public static Map<Object, EnumProperty> getStatusMap() {
		if (statusMap == null) {
			Map<Object, EnumProperty> map = new HashMap<Object, EnumProperty>();
			EnumProperty temp = null;
			EDeviceType[] vals = EDeviceType.values();
			for (EDeviceType val : vals) {
				temp = new EnumProperty(val.val, val.name, val.name);
				map.put(val.val, temp);
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
	 * @param val
	 * @param name
	 */
	private EDeviceType(Integer val, String name) {
		this.val = val;
		this.name = name;
	}

	/** @取得 设备类型val */
	public Integer getVal() {
		return val;
	}

	/** @设置 设备类型val */
	public void setVal(Integer val) {
		this.val = val;
	}

	/** @取得 设备类型name */
	public String getName() {
		return name;
	}

	/** @设置 设备类型name */
	public void setName(String name) {
		this.name = name;
	}

}
