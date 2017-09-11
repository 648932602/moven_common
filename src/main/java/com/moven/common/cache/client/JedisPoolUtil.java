package com.moven.common.cache.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	//私有连接池
	private static JedisPool pool;
	//连接URL
	private static String url = "127.0.0.1";
	//端口号
	private static Integer port = 6379;

	/**
	 * 建立连接池 真实环境，一般把配置参数缺抽取出来。
	 */
	private static void createJedisPool() {
		// 建立连接池配置参数
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数, 默认8个
		config.setMaxTotal(1000);
		// 最大空闲连接数
		config.setMaxIdle(1000);
		// 最小空闲连接数, 默认0
		config.setMinIdle(0);
		// 创建连接池
		pool = new JedisPool(config, url, port);

	}

	/**
	 * 在多线程环境同步初始化
	 */
	private static synchronized void poolInit() {
		if (pool == null){
			createJedisPool();
		}
	}

	/**
	 * 获取一个jedis 对象
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		if (pool == null){
			poolInit();
		}
		return pool.getResource();
	}

	/**
	 * 归还一个连接
	 * 
	 * @param jedis
	 */
	@SuppressWarnings("deprecation")
	public static void returnRes(Jedis jedis) {
		pool.returnResource(jedis);
	}

}