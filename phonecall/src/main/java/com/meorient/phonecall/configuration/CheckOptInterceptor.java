/** */
package com.meorient.phonecall.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.enumeration.EDeviceType;
import com.meorient.common.enumeration.EnumProperty;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.pojo.ResponseData;
import com.meorient.common.util.HttpTool;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.service.iservice.ISysAuthInfoService;

/**
 * @功能: 拦截检查
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月20日下午2:02:30
 */
@Component
public class CheckOptInterceptor extends HandlerInterceptorAdapter {
	/** 日志对象 */
	protected static Logger logger = LogManager.getLogger(CheckOptInterceptor.class);

	@Autowired
	private ISysAuthInfoService sysAuthInfoService;

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false:从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true:执行下一个拦截器,直到所有的拦截器都执行完毕
	 * 再执行被拦截的Controller然后进入拦截器链,从最后一个拦截器往回执行所有的postHandle()
	 * 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean flag = false;
		try {
			// ============================== 记录访问日志 ==============================
			Object loginedUser = null;
			String token = null;
			String url = request.getRequestURI();
			logger.info("【====" + url + "?" + request.getQueryString() + "====】");

			if (url.indexOf("/api/") > 0) {
				// 取得登陆设备类型
				String deviceType = HttpTool.getParameterFromRequest(request, "deviceType");
				if (!StringUtils.isEmpty(deviceType)) {
					Integer type = new Integer(deviceType);
					EnumProperty property = EDeviceType.getStatusByVal(type);
					if (property != null) {
						deviceType = property.getDispName();
					}
				}
				// 记录请求关键信息，用于问题排查
				User appUser = SessionManager.getCurrentUser(request);
				token = SessionManager.getUserLoginToken(request);
				loginedUser = appUser;
				if (loginedUser != null) {
					logger.info("\t用户:{custId=" + appUser.getId() + ",telNo=" + appUser.getMobile() + "',deviceType="
							+ deviceType + "}");
				} else {
					String ip = HttpTool.getIpAddr(request);
					logger.info("\t用户:{deviceType=" + deviceType + ",ip:" + ip + "}");
				}
			}

			// ============================== 验证签名 ==============================
			OptResult result = null;
			String account = HttpTool.getParameterFromRequest(request, "account");
			String sign = HttpTool.getParameterFromRequest(request, "sign");
			String timestamp = HttpTool.getParameterFromRequest(request, "timestamp");
			if (url.indexOf("/api/") > 0) {
				result = sysAuthInfoService.chenkSign(account, timestamp, sign);
			}

			// ============================== 验证用户访问权限 ==============================
			if (result == null || result.getCode() > 0) {
				if (url.indexOf("Pub/") > 0 || url.equals(request.getContextPath() + "/") || url.indexOf("/error") >= 0) {
					flag = true;
				} else if (url.indexOf("Pro/") > 0) {// 需要用户登录
					if (token == null) {
						result = EMsgCommon.noUserToken.getOptResult(logger);
					} else if (url.indexOf("/api/") > 0 && loginedUser == null
							&& SessionManager.getRepeatUserLoginToken(token) != null) {
						result = EMsgCommon.repeatUserToken.getOptResult(logger);
					} else if (loginedUser == null) {
						result = EMsgCommon.errUserToken.getOptResult(logger);
					} else {
						flag = true;
					}
				} else {
					result = EMsgCommon.errRequest.getOptResult(logger);
				}
			}
			if (!flag) {// 返回结果
				ResponseData data = new ResponseData(result);
				HttpTool.httpResponse(response, data);
			}
		} catch (Exception e) {
			logger.error("请求处理异常：", e);
		}
		return flag;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
