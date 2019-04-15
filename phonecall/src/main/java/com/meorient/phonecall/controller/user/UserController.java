/** */
package com.meorient.phonecall.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.pojo.ResponseData;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.service.iservice.IUserService;

/**
 * @功能:【user 】controller
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 14:21:54
 * @说明：<pre></pre>
 */
@RestController
@RequestMapping("/user")
public class UserController{
	
	/** 日志对象 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	/** user service*/
    @Autowired
    private IUserService userService;
    
  	/**
	 * 企业微信校对登录
	 * @param user
	 * @param request
	 * @param response
	 */
	@RequestMapping("/api/eWechatLoginPub/v1")
	public ResponseData eWechatLogin(User user, HttpServletRequest request, HttpServletResponse response) {
		User result = userService.updateEWechatLogin(user);
		OptResult info = null;
		if(result == null) {
			info = EMsgCommon.svceErrGetDataFail.getOptResult(logger);
		} else {
			info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
		}
		return new ResponseData(info,result);
	}
}
