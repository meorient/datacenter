/** */
package com.meorient.phonecall.service.iservice;

import java.util.List;

import com.meorient.common.service.iservice.IBaseService;
import com.meorient.phonecall.pojo.phonecallshare.PhoneCallShare;

/**
 * @功能:【phonecallshare 】IService
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:20:47
 * @说明：<pre></pre>
 */
public interface IPhoneCallShareService extends IBaseService<PhoneCallShare> {
		/**
		 * 分享记录
		 * @param share
		 * @return
		 */
		public int insertShare(List<PhoneCallShare> shareList);
}
