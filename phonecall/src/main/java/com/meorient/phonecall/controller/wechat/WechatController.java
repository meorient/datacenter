package com.meorient.phonecall.controller.wechat;

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
import com.meorient.phonecall.pojo.wechat.Wechat;
import com.meorient.phonecall.service.iservice.IWechatService;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日下午4:19:20
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {
	/** 日志对象 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	/** 企业微信Service */
	@Autowired
	private IWechatService wechatService;
	
	/**
	 * 得到企业微信access_token
	 * @return
	 */
	@RequestMapping("/api/getAccessTokenPub/v1")
	public ResponseData getAccessToken(Wechat wechat , HttpServletRequest request, HttpServletResponse response) {
		Wechat result = wechatService.getAccessToken(wechat);
		OptResult info = null;
		if(result == null){
			info = EMsgCommon.svceErrGetDataFail.getOptResult(logger);
		}else {
			info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
		}
		return new ResponseData(info,result);
	}
}
