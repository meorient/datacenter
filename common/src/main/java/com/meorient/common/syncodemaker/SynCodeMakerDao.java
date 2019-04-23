/** */
package com.meorient.common.syncodemaker;

import org.mybatis.spring.SqlSessionTemplate;

import com.meorient.common.dao.AbsBaseDao;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:45:43
 */
public class SynCodeMakerDao extends AbsBaseDao<ColumnInfo> {
	/**
	 * sql操作模板
	 */
	@Override
	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
	/**
	 * 批量sql操作模板
	 */
	@Override
	protected void setBatchTemplate(SqlSessionTemplate batchTemplate) {
		this.batchTemplate = batchTemplate;
	}
}
