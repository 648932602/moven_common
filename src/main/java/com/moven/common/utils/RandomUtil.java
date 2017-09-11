package com.moven.common.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
	//默认随机数长度
	public static Integer DEFAULT_LENGTH = 4;
	
	/**
	 * 获取默认长度随机数
	 * @return
	 */
	public static String getRandomCode(){
		return getRandomCode(DEFAULT_LENGTH);
	}
	
	/**
	 * 按长度获取随机数
	 * @param length 字符串长度（长度为1-10）
	 * @return
	 */
	public static String getRandomCode(Integer length){
		//防止传入参数错误
		if(Util.isBlank(length) || length > 10 || length < 1){
			return "";
		}
		String[] beforeShuffle = new String[] {"0","1","2","3","4","5","6","7", "8","9"}; 
		List<String> list = Arrays.asList(beforeShuffle); 
		Collections.shuffle(list);//打乱集合顺序
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < list.size(); i++) { 
			sb.append(list.get(i));
		}
		String afterShuffle = sb.toString(); 
		String result = afterShuffle.substring(0, length); 
		return result;
	}
}
