package com.meorient.common.constant;

import org.apache.logging.log4j.Logger;

import com.meorient.common.pojo.OptResult;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:12:58
 */
public enum EMsgCommon {
	// ======================业务逻辑错误(-200000 ~ -999999)======================
		/** 提交失败 */
		svceErrSubmitFail(-200000, "提交失败", "资料提交失败，请稍后再试"),
		/** 处理失败 */
		svceErrOptFail(-200001, "处理失败", "处理失败，请稍后再试"),
		/** 获取数据失败 */
		svceErrGetDataFail(-200002, "获取数据失败", "获取数据失败"),
		/** 新增数据失败 */
		svceErrAddDataFail(-200003, "新增数据失败", "新增数据失败"),
		/** 更新数据失败 */
		svceErrUpdateDataFail(-200004, "更新数据失败", "更新数据失败"),
		/** 文件不存在 */
		svceErrFileNotExist(-200005, "文件不存在", "文件不存在"),
		/** 上传图片失败 */
		svceErrUploadImg(-200006, "上传图片失败", "上传图片失败"),

		// ======================业务逻辑正确(大于等于0)======================
		/** 提交成功 */
		svceRigSubmitSuccess(EMsgCommon.optSuccess, "提交成功", "提交成功"),
		/** 操作成功 */
		svceRigOptSuccess(EMsgCommon.optSuccess, "操作成功", "操作成功"),
		/** 获取数据成功 */
		svceRigGetDataSuccess(EMsgCommon.optSuccess, "获取数据成功", "获取数据成功"),
		/** 新增数据成功 */
		svceRigAddDataSuccess(EMsgCommon.optSuccess, "新增数据成功", "新增数据成功"),
		/** 更新数据成功 */
		svceRigUpdateDataSuccess(EMsgCommon.optSuccess, "更新数据成功", "更新数据成功"),
		/** 没有查询到数据 */
		svceRigNoDataSuccess(EMsgCommon.optSuccess, "没有查询到数据记录", "没有查询到数据记录"),
		/** 业务逻辑：文件下载成功 */
		svceRigDownVideoFile(EMsgCommon.optSuccess, "文件下载成功", "文件下载成功"),
		/** 业务逻辑：文件下载成功 */
		svceErrDownLoadFile(EMsgCommon.exceptionCode, "文件下载失败。", "文件下载失败。"),

		// ======================系统异常(-9000 ~ -9999)======================

		/** 业务逻辑：签名超时/无效 */
		svceErrSysAuthInfoTimeOut(EMsgCommon.exceptionCode, "账户签名超时/无效。", "签名超时/无效"),
		/** 业务逻辑：帐号类型不匹配 */
		svceErrSysAuthInfotType(EMsgCommon.exceptionCode, "帐号类型不匹配。", "帐号类型不匹配。"),
		/** 业务逻辑：用户账户已存在 */
		svceErrAddMngUser(EMsgCommon.exceptionCode, "帐号已存在。", "帐号已存在。"),

		/** -9980：客户端访问token无效，禁止请求 */
		noClientToken(-9980, "客户端访问禁止请求", EMsgCommon.accessDenied),
		/** -9981：用户没有登录，无权访问。 */
		noUserToken(-9981, "您还没有登录，无权访问", "您还没有登录，请登录"),
		/** -9982：token过期 */
		errUserToken(-9982, "登录超时，请重新登录", "登录超时，请重新登录"),
		/** -9983：多用户同时登录。 */
		repeatUserToken(-9983, "您已在另一处登录，请确认密码是否外泄", "您已在另一处登录，请确认密码是否外泄"),
		/** -9984：请求无效/无权访问。 */
		errRequest(-9984, "请求无效/无权访问。", "请求无效/无权访问。"),
		/** -9997：服务器升级维护。 */
		exptSystemUpgrade(EMsgCommon.exceptionCode, "服务器尚在升级中，请稍候再试", "服务器尚在升级中，请稍候再试"),
		/** -9997：服务器开小差。 */
		exptSystemException(EMsgCommon.exceptionCode, "服务器开小差了，稍后再试！", "服务器开小差了，稍后再试！"),

		;

		/** 什么都没做 */
		public static final int optNothing = 0;
		/** 操作成功 */
		public static final int optSuccess = 1;
		/** 系统异常code */
		public static final int exceptionCode = -9997;
		/** 系统异常信息 */
		public static final String exceptionMsg = "服务器开小差了，稍后再试！";
		/** 系统异常信息 */
		public static final String accessDenied = "服务器拒绝访问！";
		/** 消息代码,大于等于0表示正确，小于表示错误 */
		private int code = 0;
		/** 消息内容（内部消息） */
		private String innerMsg;
		/** 消息内容 （外部消息） */
		private String msg;

		private EMsgCommon(int code, String innerMsg, String msg) {
			this.code = code;
			this.msg = msg;
			this.innerMsg = innerMsg;
		}

		/**
		 * @取得 消息代码大于等于0表示正确，小于表示错误
		 */
		public int getCode() {
			return code;
		}

		/** @取得 消息内容（外部消息） */
		public String getMsg() {
			return msg;
		}

		/**
		 * 转换成OptResult对象
		 *
		 * @return
		 */
		public OptResult getOptResult(Logger logger) {
			return getOptResult(logger, "");
		}

		/**
		 * 转换成OptResult对象
		 *
		 * @return
		 */
		public OptResult getOptResult(Logger logger, Object otherMsg) {
			logger.info(new OptResult(code, msg, innerMsg, otherMsg));
			return new OptResult(code, msg);
		}

		/**
		 * 转换成OptResult对象
		 *
		 * @return
		 */
		public OptResult getOptResult(Logger logger, Object otherMsg, Exception e) {
			logger.error(new OptResult(code, msg, innerMsg, otherMsg), e);
			return new OptResult(code, msg);
		}
}