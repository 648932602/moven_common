package com.moven.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.net.HttpHeaders;

/**
 * <p>
 * Title:RequestParamUtil
 * </p>
 * <p>
 * Description:Request参数解析工具类
 * </p>
 * 
 * @author moshengwei
 * @date 2017年11月23日 上午11:39:49
 */
public abstract class RequestParamUtil {

	/**
	 * Description:根据请求获取真实IP地址
	 * 
	 * @author moshengwei
	 * @date 2017年11月23日 上午11:28:22
	 * @param request
	 *            请求对象
	 * @return
	 */
	public static String getRealIp(HttpServletRequest request) {
		String result = request.getHeader("X-Real-IP");
		if (StringUtils.isEmpty(result) || "unknown".equalsIgnoreCase(result)) {
			result = request.getHeader(HttpHeaders.X_FORWARDED_FOR);
		}
		if (StringUtils.isEmpty(result) || "unknown".equalsIgnoreCase(result)) {
			result = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(result) || "unknown".equalsIgnoreCase(result)) {
			result = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(result) || "unknown".equalsIgnoreCase(result)) {
			result = request.getRemoteAddr();
		}
		String[] ips = StringUtils.split(result, ',');
		if (ArrayUtils.isNotEmpty(ips)) {
			result = ips[0];
		}
		return result;
	}

	/**
	 * Description:获取使用的代理
	 * 
	 * @author moshengwei
	 * @date 2017年11月23日 上午11:41:26
	 * @param request
	 *            请求对象
	 * @return
	 */
	public static String getUserAgent(HttpServletRequest request) {
		return request.getHeader("user-agent");
	}
}
