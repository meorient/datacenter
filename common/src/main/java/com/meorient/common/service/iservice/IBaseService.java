package com.meorient.common.service.iservice;

import java.util.List;
import java.util.Map;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:09:52
 */
public interface IBaseService<P extends BasePojo> {

	/**
	 * 根据主键或唯一键查找数据
	 *
	 * @param p
	 * @return
	 */
	public P selectUnique(P p);

	/**
	 * 根据条件查询记录
	 *
	 * @param p
	 * @return
	 */
	public List<P> selectList(P p);
	
	/**
	 * 根据条件查询记录
	 *
	 * @param p
	 * @return
	 */
	public Map<String,P> selectMap(P p , String key);
	
	/**
	 * 根据条件查询记录
	 *
	 * @param p
	 * @return
	 */
	public Map<String,P> selectMap(String mapperId , P p ,String key);

	/**
	 * 插入一条数据
	 *
	 * @param p
	 * @return
	 */
	public int insert(P p);

	/**
	 * 修改一条数据
	 *
	 * @param p
	 * @return
	 */
	public int update(P p);

	/**
	 * 批量插入数据
	 *
	 * @param list
	 * @return
	 */
	public int insertList(List<P> list);

	/**
	 * 批量修改数据
	 *
	 * @param list
	 * @return
	 */
	public int updateList(List<P> list);
}