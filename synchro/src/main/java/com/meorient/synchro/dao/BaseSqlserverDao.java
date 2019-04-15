package com.meorient.synchro.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.meorient.common.dao.AbsBaseDao;
import com.meorient.common.pojo.BasePojo;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年3月19日下午4:37:22
 */
public class BaseSqlserverDao<P extends BasePojo> extends AbsBaseDao<P> {

	/**
	 * @设置 单条sql操作模板
	 */
	@Override
	@Autowired
	@Qualifier("sqlserverSqlSessionTemplate")
	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	/**
	 * @设置 批量sql操作模板
	 */
	@Override
	@Autowired
	@Qualifier("sqlserverSqlSessionBatchTemplate")
	protected void setBatchTemplate(SqlSessionTemplate batchTemplate) {
		this.batchTemplate = batchTemplate;
	}

}
