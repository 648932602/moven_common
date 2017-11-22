package com.moven.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@SuppressWarnings("restriction")
public class DESUtil {
	// 固定的加密字符串(DES加密必须要求加密字符串长度为8)
	private static String secretKey = "isso_key";
	// 默认编码方式
	private static String charSet = "UTF-8";

	/**
	 * DES解密
	 * 
	 * @param secretData
	 * @return
	 * @throws Exception
	 */
	public static String decryption(String secretData) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec(secretKey.getBytes(charSet));
		cipher.init(Cipher.DECRYPT_MODE, generateKey(secretKey), iv);

		byte[] buf = cipher.doFinal(Base64.decode(secretData));
		return new String(buf);
	}

	/**
	 * DES加密
	 * 
	 * @param secretData
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(secretKey.getBytes("gbk"));
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, generateKey(secretKey), iv);

		byte[] b = cipher.doFinal(data.getBytes());
		return Base64.encode(b);
	}

	/**
	 * 获得加密密钥
	 * 
	 * @param secretKey
	 * @return
	 */
	private static SecretKey generateKey(String secretKey) throws Exception {
		DESKeySpec desKeySpec = new DESKeySpec(secretKey.getBytes(charSet));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		return keyFactory.generateSecret(desKeySpec);
	}
}
