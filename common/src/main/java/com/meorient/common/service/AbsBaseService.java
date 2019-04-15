package com.meorient.common.service;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.meorient.common.dao.AbsBaseDao;
import com.meorient.common.pojo.BasePojo;
import com.meorient.common.service.iservice.IBaseService;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:09:04
 */
public abstract class AbsBaseService<P extends BasePojo, D extends AbsBaseDao<P>> implements IBaseService<P> {

	/** 日志 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	/** dao工具 */
	protected D dao;

	/**
	 * @设置 dao工具
	 */
	protected abstract void setDao(D dao);

	/**
	 * 根据主键或唯一键查找数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public P selectUnique(P p) {
		return dao.selectUnique(p);
	}

	/**
	 * 根据条件查询记录
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public List<P> selectList(P p) {
		return dao.selectList(p);
	}
	
	/**
	 * 根据条件查询记录
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public Map<String,P> selectMap(P p , String key) {
		return dao.selectMap(p , key);
	}
	
	/**
	 * 根据条件查询记录
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public Map<String,P> selectMap(String mapperId , P p ,String key) {
		return dao.selectMap(mapperId , p , key);
	}

	/**
	 * 插入一条数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int insert(P p) {
		int count = dao.insert(p);
		return count;
	}

	/**
	 * 修改一条数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int update(P p) {
		return dao.update(p);
	}

	/**
	 * 批量插入数据
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int insertList(List<P> list) {
		return dao.insertList(list);
	}

	/**
	 * 批量修改数据
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int updateList(List<P> list) {
		return dao.updateList(list);
	}
}
