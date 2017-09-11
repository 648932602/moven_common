package com.moven.common.cache;

public class MemCacheUtil {
//	// 默认缓存管理器对象
//	private static MemCachedClient memCachedClient;
//	// 默认缓存存活时间，单位：毫秒
//	private static final Integer DEFAULT_TIME_OUT = 7 * 24 * 60 * 60 * 1000;
//
//	public static int count = 0;
//
//	static {
//		memCachedClient = MemCachePoolUtil.getMemCachedClient();
//	}
//
//	/**
//	 * 保存缓存
//	 * 
//	 * @param key
//	 * @param value
//	 * @param millisecond
//	 *            毫秒数
//	 * @return
//	 */
//	public static boolean set(String key, Object value, long millisecond) throws Exception {
//		boolean result = false;
//		if (value != null) {
//			try {
//				result = memCachedClient.set(key, value, new Date(millisecond));
//			} catch (Exception e) {
//				LogUtil.error(MemCacheUtil.class, e.getMessage());
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 保存缓存
//	 * 
//	 * @param key
//	 *            键
//	 * @param value
//	 *            值
//	 * @return
//	 */
//	public static boolean set(String key, Object value) throws Exception {
//		return set(key, value, DEFAULT_TIME_OUT);
//	}
//
//	/**
//	 * 读取缓存
//	 * 
//	 * @param key
//	 *            键
//	 * @return
//	 */
//	public static Object get(String key) throws Exception {
//		Object result = null;
//		try {
//			result = memCachedClient.get(key);
//		} catch (Exception e) {
//			LogUtil.error(MemCacheUtil.class, e.getMessage());
//		}
//		return result;
//	}
//
//	/**
//	 * 清除缓存
//	 */
//	public static boolean removeAll() {
//		boolean result = true;
//		try {
//			memCachedClient.flushAll();
//		} catch (Exception e) {
//			result = false;
//			LogUtil.error(MemCacheUtil.class, e.getMessage());
//		}
//		return result;
//	}
//
//	/**
//	 * 清除指定缓存
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public static boolean remove(String key) {
//		boolean result = false;
//		try {
//			result = memCachedClient.delete(key);
//		} catch (Exception e) {
//			LogUtil.error(MemCacheUtil.class, e.getMessage());
//		}
//		return result;
//	}
}
