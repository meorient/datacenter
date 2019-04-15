/** */
package com.meorient.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * @功能:request&response处理
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:39:09
 */
public class HttpTool {
	/** 日志对象 */
	protected static Logger logger = LogManager.getLogger(HttpTool.class);

	/**
	 * 获取ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.startsWith("192")) {
			// ip = "116.231.127.142";// 上海ip
		}
		return ip;
	}

	/**
	 * 从客户端读取cookie，返回一个字符串
	 * 
	 * @param request
	 * @param cookieName
	 *            cookie的名称
	 * @return
	 */
	public static String getStrFromCookie(HttpServletRequest request, String cookieName) {
		try {
			if (request.getCookies() != null) {
				for (Cookie c : request.getCookies()) {
					if (cookieName != null && cookieName.equals(c.getName())) {
						return URLDecoder.decode(c.getValue(), "utf-8");
					}
				}
			}
		} catch (Exception ex) {
			logger.error("从客户端读取cookie失败", ex);
		}
		return "";
	}

	/**
	 * 从客户端读取cookie，返回对象
	 * 
	 * @param request
	 * @param cookieName
	 *            cookie的名称
	 * @param object
	 * @return
	 */
	public static <T> T getObjectFromCookie(HttpServletRequest request, String cookieName, Class<T> object) {
		String value = getStrFromCookie(request, cookieName);
		try {
			return JsonTool.getObj(value, object);
		} catch (Exception ex) {
			logger.error("从客户端读取cookie，返回对象失败", ex);
		}
		return null;
	}

	/**
	 * 删除cookie
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 *            cookie的名字
	 */
	public static void deleteClientCookie(HttpServletResponse response, String cookieName) {
		try {
			Cookie myCookie = new Cookie(cookieName, null);
			myCookie.setMaxAge(0);
			myCookie.setPath("/");
			response.addCookie(myCookie);
		} catch (Exception ex) {
			logger.error("清空Cookies发生异常！", ex);
		}
	}

	/**
	 * 从输入流中获取网络参数
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getParameterFromStream(HttpServletRequest request) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = request.getInputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = in.read(b)) != -1) {
			out.write(b, 0, len);
		}
		out.close();

		String paramStr = out.toString();
		String[] paramArray = paramStr.split("&");
		for (int i = 0; i < paramArray.length; i++) {
			String[] tempArr = paramArray[i].split("=");
			if (tempArr.length > 1) {
				paramMap.put(tempArr[0], tempArr[1]);
			}
		}
		return paramMap;
	}

	/**
	 * 通过指定key从request获取值<br>
	 * 优先从hedders里面获取，如果hedders没有从parameters里面获取
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getParameterFromRequest(HttpServletRequest request, String key) {
		return getParameterFromRequest(request, key, null);
	}

	/**
	 * 通过指定key从request获取值<br>
	 * 优先从hedders里面获取，如果hedders没有从parameters里面获取,如果没有就指定defaultValue
	 * 
	 * @param request
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getParameterFromRequest(HttpServletRequest request, String key, String defaultValue) {
		String value = request.getHeader(key);
		if (StringUtils.isEmpty(value)) {
			value = request.getParameter(key);
		}
		return StringUtils.isEmpty(value) == true ? defaultValue : value;
	}

	/**
	 * 检查浏览器是否是微信浏览器，并且版本是否大于等于version
	 * 
	 * @param request
	 * @param version
	 * @return
	 */
	public static boolean checkBrower(HttpServletRequest request, double version) {
		// String browser = "Mobile/10B329 MicroMessenger/4.0.1".toLowerCase();
		String browser = request.getHeader("USER-AGENT").toLowerCase();
		Pattern pat = Pattern.compile("micromessenger\\/([\\d]+[\\.]{0,1}[\\d]{0,1})");
		Matcher matcher = pat.matcher(browser);
		Double v = 0D;// 微信版本号，5.0才支持微信支付
		if (matcher.find()) {
			v = new Double(matcher.group(1));
			if (v >= version) {
				return true;
			}
		}
		return false;
	}

	/**
	 * response返回数据
	 * 
	 * @param response
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static void httpResponse(HttpServletResponse response, Object obj) {
		httpResponse(response, obj, ResponseContentType.json, "UTF-8");
	}

	/**
	 * response返回数据
	 * 
	 * @param response
	 * @param obj
	 * @param type
	 * @param encode
	 * @return
	 * @throws IOException
	 */
	public static void httpResponse(HttpServletResponse response, Object obj, ResponseContentType type, String encode) {
		PrintWriter writer = null;
		try {
			String str = null;
			if (type == ResponseContentType.json) {
				str = JsonTool.getString(obj);
			} else {
				str = obj.toString();
			}
			response.setContentType(type.getType());
			response.setCharacterEncoding(encode);
			writer = response.getWriter();
			writer.write(str);
			writer.flush();
		} catch (Exception ex) {
			logger.error("服务端返回异常", ex);
			try {
				response.sendError(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			} catch (IOException e) {}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * 
	 * @功能:response返回数据的类型
	 * @作者:wangjz
	 * @日期:2016年3月23日下午12:00:29
	 */
	public enum ResponseContentType {
		/** javascript */
		javascript("text/javascript"),
		/** text */
		text("text/plain"),
		/** html */
		html("text/html"),
		/** xml */
		xml("text/xml"),
		/** json */
		json("application/json");

		/** response返回内容的类型 */
		private String type;

		private ResponseContentType(String type) {
			this.type = type;
		}

		/**
		 * 取得response返回内容的类型
		 * 
		 * @return
		 */
		public String getType() {
			return type;
		}
	}
}
