/** */
package com.meorient.common.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:17:36
 */
public class StringTool {
	/** 日志 */
	protected static Logger logger = LogManager.getLogger(StringTool.class);

	/**
	 * 判断string是否为空或空字符串
	 * 
	 * @param obj
	 * @param trueVal
	 * @return
	 */
	public static boolean isEmpty(String obj) {
		return obj == null || obj.trim().length() < 1;
	}

	/**
	 * 将java转义字符转换成html标签
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceJavaCharToHtml(String str) {
		if (str != null) {
			str = str.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			str = str.replaceAll("(\")", "&quot;");
			str = str.replaceAll("(\')", "&quot;");
			str = str.replaceAll("\\\\", "");
			str = str.replaceAll("&quot;", "\"");
			str = str.replaceAll("&gt;", ">");
			str = str.replaceAll("&lt;", "<");
			str = str.replaceAll("&amp;", "&");
		}
		return str;
	}

	/**
	 * 产生length长度的一个随机数
	 * 
	 * @param length
	 * @return
	 */
	public static String bringValidateCode(int length) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < length; i++) {
			Double d = Math.random() * 10;
			s.append(d.intValue());
		}
		return s.toString();
	}

	/**
	 * 获取交易时的批次号、交易号等等
	 * 
	 * @param prefix 前缀如 DD、PC...
	 * @param dateFormat 时间格式 如 yyyyMMddHHmmssSSS
	 * @param suffixLen 末尾追加的随即串长度
	 * @return
	 */
	public static String getTimeCode(String prefix, String dateFormat, int suffixLen) {
		return prefix + new SimpleDateFormat(dateFormat).format(new Date()) + bringValidateCode(suffixLen);
	}

	/**
	 * 在字符前加0，达到一定的位数，目前最长支持补10位零
	 * 
	 * @param oldStr
	 * @param length
	 * @return
	 */
	public static String fillZero(String oldStr, int length) {
		String[] zeorArray = new String[] { "", "0", "00", "000", "0000", "00000", "000000", "0000000", "00000000",
				"000000000", "0000000000" };
		if (length < oldStr.length()) {
			return oldStr;
		}
		return zeorArray[length - oldStr.length()] + oldStr;
	}

	/**
	 * md5加密:使用UTF-8，结果转成全大写
	 * 
	 * @param str
	 * @return
	 */
	public static String MD5Encode(String str) {
		return MD5Encode(str, "UTF-8", true);
	}

	/**
	 * md5加密：使用UTF-8,根据参数转成全大写
	 * 
	 * @param str
	 * @param upperCase
	 * @return
	 */
	public static String MD5Encode(String str, boolean upperCase) {
		return MD5Encode(str, "UTF-8", upperCase);
	}

	/**
	 * md5加密
	 * 
	 * @param str 要加密的字符串
	 * @param charsetname 字符编码 UTF-8
	 * @param upperCase 是否转为大写
	 * @return
	 */
	public static String MD5Encode(String str, String charsetname, boolean upperCase) {
		StringBuffer resultSb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] arr = md.digest(str.getBytes(charsetname));
			for (int b : arr) {
				if (b < 0) {
					b = 256 + b;
				}
				if (b <= 15) {
					resultSb.append("0");
				}
				resultSb.append(Integer.toHexString(b));
			}
			if (upperCase) {
				return resultSb.toString().toUpperCase();
			} else {
				return resultSb.toString();
			}
		} catch (Exception ex) {
			logger.error("md5加密失败！", ex);
		}
		return null;
	}

	/**
	 * sha1加密
	 * 
	 * @param str
	 * @return
	 */
	public static String sha1Encode(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.reset();
			md.update(str.getBytes("UTF-8"));
			byte[] arr = md.digest();

			Formatter formatter = new Formatter();
			for (byte b : arr) {
				formatter.format("%02x", b);
			}
			String result = formatter.toString();
			formatter.close();
			return result;
		} catch (Exception ex) {
			logger.error("SHA-1加密失败！", ex);
		}
		return null;
	}
}
