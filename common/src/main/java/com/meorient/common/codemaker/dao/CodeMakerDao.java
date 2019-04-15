/** */
package com.meorient.common.codemaker.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.meorient.common.codemaker.po.ColumnInfo;
import com.meorient.common.dao.AbsBaseDao;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:45:43
 */
public class CodeMakerDao extends AbsBaseDao<ColumnInfo> {
	/**
	 * @设置 单条sql操作模板
	 */
	@Override
	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	/**
	 * @设置 单条sql操作模板
	 */
	public void setTemplate2(SqlSessionTemplate template) {
		super.template = template;
	}

	/**
	 * @设置 批量sql操作模板
	 */
	@Override
	protected void setBatchTemplate(SqlSessionTemplate batchTemplate) {
		this.batchTemplate = batchTemplate;
	}

}
