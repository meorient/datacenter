/** */
package com.meorient.common.service;

import com.meorient.common.dao.AbsBaseDao;
import com.meorient.common.pojo.BasePojo;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:09:04
 */
public abstract class AbsBaseCacheService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseService<P, D> {
	/**
	 * 初始化缓存数据，主要通过@PostConstruct注解初始化bean时首次自动加载
	 * 
	 */
	protected abstract void init();

}
