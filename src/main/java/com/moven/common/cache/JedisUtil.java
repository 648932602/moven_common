package com.moven.common.cache;

import org.apache.commons.lang.ArrayUtils;

import com.moven.common.cache.client.JedisPoolUtil;
import com.moven.common.utils.SerializeUtil;

import redis.clients.jedis.Jedis;

public class JedisUtil {
	// 默认缓存存活时间
	private static final Integer DEFAULT_TIME_OUT = 7 * 24 * 60 * 60;
	// 移除所有状态位
	private static final String STATUS_OK = "OK";

	/**
	 * 默认添加缓存
	 * 
	 * @param key
	 *            缓存键
	 * @param value
	 *            缓存值
	 * @return 添加结果
	 */
	public static boolean set(String key, Object value) {
		return set(key, value, DEFAULT_TIME_OUT);
	}

	/**
	 * 添加缓存，有存活时间
	 * 
	 * @param key
	 *            缓存键
	 * @param value
	 *            缓存值
	 * @param timeOut
	 *            缓存失效时间
	 * @return 添加结果
	 */
	public static boolean set(String key, Object value, Integer timeOut) {
		boolean result = false;
		if (null == timeOut) {
			result = false;
			return result;
		}
		try {
			Jedis jedis = JedisPoolUtil.getJedis();
			jedis.set(key.getBytes(), SerializeUtil.serialize(value));
			jedis.expire(key.getBytes(), timeOut);
			JedisPoolUtil.returnRes(jedis);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取指定键值缓存
	 * 
	 * @param key
	 *            缓存键
	 * @return 缓存对象
	 */
	public static Object get(String key) {
		Object result = null;
		try {
			Jedis jedis = JedisPoolUtil.getJedis();
			byte[] value = jedis.get(key.getBytes());
			if(ArrayUtils.isEmpty(value)){
				result = null;
			} else {
				result = SerializeUtil. unserialize(value);
			}
			JedisPoolUtil.returnRes(jedis);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * 移除指定键值缓存
	 * 
	 * @return 移除结果
	 */
	public static boolean remove(String key) {
		boolean result = false;
		try {
			Jedis jedis = JedisPoolUtil.getJedis();
			long effectNum = jedis.del(key.getBytes());
			JedisPoolUtil.returnRes(jedis);
			if(effectNum > 0){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 移除所有缓存
	 * 
	 * @return 移除结果
	 */
	public static boolean removeAll() {
		boolean result = false;
		try {
			Jedis jedis = JedisPoolUtil.getJedis();
			String resultStr = jedis.flushAll();
			JedisPoolUtil.returnRes(jedis);
			if(STATUS_OK.equals(resultStr)){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
