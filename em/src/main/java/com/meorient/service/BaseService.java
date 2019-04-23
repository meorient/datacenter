package com.meorient.service;

import com.meorient.common.dao.AbsBaseDao;
import com.meorient.common.pojo.BasePojo;
import com.meorient.common.service.AbsBaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
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