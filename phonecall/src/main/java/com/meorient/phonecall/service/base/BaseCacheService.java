/** */
package com.meorient.phonecall.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.meorient.common.dao.AbsBaseDao;
import com.meorient.common.pojo.BasePojo;
import com.meorient.common.service.AbsBaseCacheService;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月20日下午2:42:21
 */
public abstract class BaseCacheService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseCacheService<P, D> {
	/**
	 * @设置 dao工具
	 */
	@Override
	@Autowired
	protected void setDao(D dao) {
		this.dao = dao;
	}
}
