/** */
package com.meorient.phonecall.controller.phonecallshare;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.pojo.ResponseData;
import com.meorient.phonecall.configuration.SessionManager;
import com.meorient.phonecall.pojo.phonecallshare.PhoneCallShare;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.service.iservice.IPhoneCallShareService;

/**
 * @功能:【phonecallshare 】controller
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:20:47
 * @说明：<pre></pre>
 */
@RestController
@RequestMapping("/phonecallshare")
public class PhoneCallShareController{
	
	/** 日志对象*/
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	/** 分享Service*/
    @Autowired
    private IPhoneCallShareService phoneCallshareService;
    
  	/**
	 * 分享录音记录
	 * @param phonecallshare
	 * @param request
	 * @param response
	 */
	@RequestMapping("/api/sharePro/v1")
	public ResponseData share(@RequestBody ArrayList<PhoneCallShare> shareList, HttpServletRequest request, HttpServletResponse response) {
		Timestamp now = Timestamp.valueOf(LocalDateTime.now());
		User user = SessionManager.getCurrentUser(request);
		for( PhoneCallShare pcs : shareList ) {
			pcs.setShareFromId(user.getId());
			pcs.setShareFromName(user.getName());
			pcs.setCreateTime(now);
			pcs.setStatus(1);
		}
		int result = phoneCallshareService.insertShare(shareList);
		OptResult info = EMsgCommon.svceRigAddDataSuccess.getOptResult(logger);
		return new ResponseData(info,result);
	}
}
