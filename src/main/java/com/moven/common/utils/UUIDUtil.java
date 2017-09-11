package com.moven.common.utils;

import java.util.UUID;
  
  
public class UUIDUtil {
	//默认随机数长度
	public static Integer DEFAULT_LENGTH = 8;
	//默认步长
	public static Integer STEP = 32 / DEFAULT_LENGTH;
	//大小写字母和数字字符集
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
		"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
		"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
		"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
		"W", "X", "Y", "Z" };

	/**
	 * 获取默认长度UUID
	 * @return
	 */
	public static String generateShortUuid() {
		return generateShortUuid(DEFAULT_LENGTH);
	}
	
	/**
	 * 按长度获取UUID
	 * @param length 字符串长度（长度为1-32）
	 * @return
	 */
	public static String generateShortUuid(Integer length) {
		//防止传入参数错误
		int max = 32 / STEP;
		if(Util.isBlank(length) || length > max || length < 1){
			return "";
		}
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");//将生成的32位UUID字符串做去“-”处理
		for (int i = 0; i < length; i++) {
			String str = uuid.substring(i * STEP, (i + 1 ) * STEP);//按步长截取字符串
			int x = Integer.parseInt(str, 16);//将截取的字符串转换成16进制数字
			shortBuffer.append(chars[x % 0x3E]);//转换的数字除以62取余
		}
		return shortBuffer.toString();
	}
}  