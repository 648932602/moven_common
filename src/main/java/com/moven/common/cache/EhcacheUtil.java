package com.moven.common.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheUtil {
//	缓存配置文件路径
	private static String cacheXMLPath = "/conf/xml/ehcache.xml";
//	默认缓存管理器对象
	private static CacheManager manager;
//	默认缓存对象
	private static Cache commonCache;
//	默认缓存存活时间
	private static final Integer DEFAULT_TIME_OUT = 7 * 24 * 60 * 60;
	static{
		String fileName = Class.class.getClass().getResource(cacheXMLPath).getPath();  
		manager = new CacheManager(fileName);
		commonCache = manager.getCache("commonCache");
	}
	
	/**
	 * 默认添加缓存
	 * @param key	缓存键
	 * @param value	缓存值
	 * @return 添加结果
	 */
	public static boolean set(String key, Object value){
		return set(key, value, DEFAULT_TIME_OUT);
	}
	
	/**
	 * 添加缓存，有存活时间
	 * @param key	缓存键
	 * @param value	缓存值
	 * @param timeOut	缓存失效时间
	 * @return 添加结果
	 */
	public static boolean set(String key, Object value, Integer timeOut){
		boolean result = true;
		if(null == timeOut){
			result = false;
			return result;
		}
		try{
			Element newCache = new Element(key, value);
			newCache.setTimeToLive(timeOut);
			commonCache.put(newCache);
		} catch(Exception e){
			result = false;
		}
		return result;
	}
	
	/**
	 * 获取指定键值缓存
	 * @param key 缓存键
	 * @return	缓存对象
	 */
	public static Object get(String key){
		Object result = null;
		try{
			Element cacheElement = commonCache.get(key);
			result = cacheElement.getObjectValue();
		} catch(Exception e){
			result = null;
		}
		return result;
	}
	
	/**
	 * 移除指定键值缓存
	 * @return 移除结果
	 */
	public static boolean remove(String key){
		boolean result = true;
		try{
			result = commonCache.remove(key);
		} catch(Exception e){
			result = false;
		}
		return result;
	}
	
	/**
	 * 移除所有缓存
	 * @return 移除结果
	 */
	public static boolean removeAll(){
		boolean result = true;
		try{
			commonCache.removeAll();
		} catch(Exception e){
			result = false;
		}
		return result;
	}
}
