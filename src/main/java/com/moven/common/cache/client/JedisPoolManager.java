package com.moven.common.cache.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moven.common.config.CommonProperties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * <p>JedisPoolConfigration</p>
 * <p>Description:</p>
 * @author moshengwei
 * @date 2017年11月26日 下午6:28:08
 */
@Component
public class JedisPoolManager {
	
	private static CommonProperties commonProperties;

	@Autowired
	public void setCommonProperties(CommonProperties commonProperties) {
		JedisPoolManager.commonProperties = commonProperties;
	}

	//私有连接池
	private static JedisPool pool;
	
	/**
	 * 建立连接池 真实环境，一般把配置参数缺抽取出来。
	 */
	private static void init() {
		// 建立连接池配置参数
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数, 默认8个
		config.setMaxTotal(commonProperties.getRedisMaxTotal());
		// 最大空闲连接数
		config.setMaxIdle(commonProperties.getRedisMaxIdle());
		// 最大等待时间
		config.setMaxWaitMillis(commonProperties.getRedisMaxWaitMillis());
		// 设置获取时检察
		config.setTestOnBorrow(commonProperties.getRedisTestOnBorrow());
		// 创建连接池
		pool = new JedisPool(config, commonProperties.getRedisHostName(), commonProperties.getRedisHostPort());
		System.out.println("--- hostname = " + commonProperties.getRedisHostName() + "，hostport = "
				+ commonProperties.getRedisHostPort() + "---");
	}

	/**
	 * 获取一个jedis 对象
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		if(null == pool) {
			init();
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