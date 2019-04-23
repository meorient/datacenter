/** */
package com.meorient.dao;

import com.meorient.common.dao.AbsBaseDao;
import com.meorient.common.pojo.BasePojo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */
public class BaseDao<P extends BasePojo> extends AbsBaseDao<P> {

	/**
	 * @设置 单条sql操作模板
	 */
	@Override
	@Autowired
	@Qualifier("masterDBSqlSessionTemplate")
	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	/**
	 * @设置 批量sql操作模板
	 */
	@Override
	@Autowired
	@Qualifier("masterDBSqlSessionBatchTemplate")
	protected void setBatchTemplate(SqlSessionTemplate batchTemplate) {
		this.batchTemplate = batchTemplate;
	}

}
