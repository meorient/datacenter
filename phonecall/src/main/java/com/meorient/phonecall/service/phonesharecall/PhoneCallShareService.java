/** */
package com.meorient.phonecall.service.phonesharecall;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meorient.phonecall.dao.phonecallshare.PhoneCallShareDao;
import com.meorient.phonecall.pojo.phonecallshare.PhoneCallShare;
import com.meorient.phonecall.service.base.BaseService;
import com.meorient.phonecall.service.iservice.IPhoneCallShareService;

/**
 * @功能:【phonecallshare 】Service
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:20:47
 * @说明：<pre></pre>
 */
@Service
public class PhoneCallShareService extends BaseService<PhoneCallShare, PhoneCallShareDao> implements IPhoneCallShareService {
	
	/**
	 * 方法重写
	 */ 
	@Override
	public int insertShare(List<PhoneCallShare> shareList) {
		int result = this.dao.insertList(shareList);
		return result;
	}
}
