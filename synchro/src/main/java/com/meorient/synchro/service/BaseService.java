package com.meorient.synchro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.meorient.common.dao.AbsBaseDao;
import com.meorient.common.pojo.BasePojo;
import com.meorient.common.service.AbsBaseService;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年3月19日下午4:31:19
 */
public class BaseService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseService<P, D> {
	/**
	 * @设置 dao工具
	 */
	@Override
	@Autowired
	protected void setDao(D dao) {
		this.dao = dao;
	}
}