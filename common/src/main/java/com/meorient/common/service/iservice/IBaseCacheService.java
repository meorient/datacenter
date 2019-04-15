/** */
package com.meorient.common.service.iservice;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:09:04
 */
public interface IBaseCacheService<P extends BasePojo, R> extends IBaseService<P> {

	/**
	 * 清理缓存
	 */
	public void cleanCache(P po);

	/**
	 * 取得缓存数据
	 * 
	 * @param po
	 * @return
	 */
	public R getCacheDataByKey(P po);

}
