package com.moven.common.utils;

public class Util {
	/**
	 * 字符串非空判断（"",null,"null"）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (null == str || str.trim().length() == 0
				|| "null".equalsIgnoreCase(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串非空判断（"",null,"null"）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(Object o) {
		if (null == o || o.toString().trim().length() == 0
				|| "null".equalsIgnoreCase(o.toString())) {
			return true;
		} else {
			return false;
		}
	}
}
