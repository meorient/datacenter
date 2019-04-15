///** */
//package com.meorient.phonecall;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.web.AbstractErrorController;
//import org.springframework.boot.autoconfigure.web.ErrorAttributes;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.meorient.common.constant.EMsgCommon;
//import com.meorient.common.pojo.OptResult;
//import com.meorient.common.pojo.ResponseData;
//
///**
// * @功能:异常处理
// * @项目名:phonecall
// * @作者:chuxu
// * @日期:2019年3月20日下午2:42:21
// */
//@ControllerAdvice
//@RestController
//@RequestMapping("${server.error.path:${error.path:/error}}")
//public class GlobalException extends AbstractErrorController {
//
//	/** 日志对象 */
//	protected Logger logger = LogManager.getLogger(this.getClass());
//	@Value("${server.error.path:${error.path:/error}}")
//	private String errorPath = "/error";
//
//	/**
//	 * 构造函数
//	 * 
//	 * @param errorAttributes
//	 */
//	public GlobalException(ErrorAttributes errorAttributes) {
//		super(errorAttributes);
//	}
//
//	/**
//	 * 处理全局的/error请求
//	 * 
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping
//	public ResponseData error(HttpServletRequest request) {
//		// 参考org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter第79行
//		Object exception = request.getAttribute("javax.servlet.error.exception");
//		if (exception != null) {
//			return defaultExceptionHandler((Exception) exception);
//		}
//		Object errCode = request.getAttribute("javax.servlet.error.status_code");
//		if (errCode != null && errCode.toString().length() > 0) {
//			Object requestUri = request.getAttribute("javax.servlet.error.request_uri");
//			if (requestUri != null) {
//				OptResult result = new OptResult(EMsgCommon.exceptionCode, "请求失败", "status:" + errCode.toString()
//						+ ",url:" + requestUri.toString());
//				result.log(logger);
//				return new ResponseData(result);
//			}
//
//		}
//
//		// Enumeration<String> e = request.getAttributeNames();
//		// while (e.hasMoreElements()) {
//		// String name = e.nextElement();
//		// Object obj = request.getAttribute(name);
//		// logger.info("----------" + name + "----" + obj.toString());
//		// }
//		Object msg = request.getAttribute("javax.servlet.error.message");
//		OptResult result = EMsgCommon.exptSystemException.getOptResult(logger, msg);
//		return new ResponseData(result);
//	}
//
//	/**
//	 * 处理全局的exception异常
//	 * 
//	 * @param e
//	 * @return
//	 */
//	@ExceptionHandler(value = Exception.class)
//	@ResponseBody
//	public ResponseData defaultExceptionHandler(Exception e) {
//		OptResult result = EMsgCommon.exptSystemException.getOptResult(logger, "", e);
//		return new ResponseData(result);
//	}
//
//	@Override
//	public String getErrorPath() {
//		return errorPath;
//	}
//}
