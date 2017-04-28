package com.moven.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropUtil {
	// 系统目录
	public static String ROOT_PATH = "";
	// classpath中资源文件的文件夹
	public static String CLASSPATH_FLODER = "conf/properties";

	/**
	 * Description:获取properties配置文件路径
	 * 
	 * @author moshengwei
	 * @date 2017年2月14日 下午4:10:53
	 * @return
	 */
	private static String getPROP_ROOT() {
		if (StringUtils.isBlank(ROOT_PATH)) {
			ROOT_PATH = PropUtil.class.getClassLoader().getResource(CLASSPATH_FLODER).getPath();
		}
		File localFile = new File(ROOT_PATH);
		if (localFile.exists()) {
			return ROOT_PATH + File.separatorChar;
		}
		return null;
	}

	/**
	 * Description:读取Properties文件
	 * 
	 * @author moshengwei
	 * @date 2017年2月14日 下午3:42:45
	 * @param fname
	 *            文件名
	 * @return
	 */
	private static Properties loadProp(String fname) {
		try {
			Properties prop = null;
			Hashtable<String, Object> htmlfileHash = new Hashtable<String, Object>();
			File f = new File(getPROP_ROOT() + fname + ".properties");
			if (f.exists()) {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(f);
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

				prop.load(reader);
				reader.close();
				bis.close();
				fis.close();

				htmlfileHash.put(fname, prop);

				return (Properties) htmlfileHash.get(fname);
			}
			return null;

		} catch (Exception e) {
			// LogUtil.info(PropUtil.class, fname + " not found!");
			return null;
		}
	}

	/**
	 * Description:读取Properties文件键值
	 * 
	 * @author moshengwei
	 * @date 2017年2月14日 下午3:49:55
	 * @param fname
	 * @param key
	 * @param includeInv
	 * @return
	 */
	public static String getPropValue(String fname, String key) {

		Properties propFile = loadProp(fname);
		if (null == propFile) {
			// LogUtil.info(PropUtil.class, fname + " not found!");
			return "";
		}

		String propVal = propFile.getProperty(key);
		if (StringUtils.isBlank(propVal)) {
			return "";
		}
		
		return propVal.trim();

	}

}
