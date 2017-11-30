package com.moven.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title:CommonProperties</p>
 * <p>Description:</p>
 * @author moshengwei
 * @date 2017年11月26日 下午4:33:42
 */
@Configuration
public class CommonProperties {

	@Value("${redis.moven.host}")
	private String redisHostName;
	@Value("${redis.moven.port}")
	private int redisHostPort;
	@Value("${redis.moven.password}")
	private String redisPassword;
	@Value("${redis.moven.maxIdle}")
	private int redisMaxIdle;
	@Value("${redis.moven.maxTotal}")
	private int redisMaxTotal;
	@Value("${redis.moven.maxWait}")
	private int redisMaxWaitMillis;
	@Value("${redis.moven.timeout}")
	private int redisTimeout;
	@Value("${redis.moven.testOnBorrow}")
	private boolean redisTestOnBorrow;
	@Value("${redis.moven.database}")
	private int redisDatabase;
	@Value("${redis.moven.cache.database}")
	private int redisCacheDatabase;

	public String getRedisHostName() {
		return redisHostName;
	}

	public void setRedisHostName(String redisHostName) {
		this.redisHostName = redisHostName;
	}

	public int getRedisHostPort() {
		return redisHostPort;
	}

	public void setRedisHostPort(int redisHostPort) {
		this.redisHostPort = redisHostPort;
	}

	public String getRedisPassword() {
		return redisPassword;
	}

	public void setRedisPassword(String redisPassword) {
		this.redisPassword = redisPassword;
	}

	public int getRedisMaxIdle() {
		return redisMaxIdle;
	}

	public void setRedisMaxIdle(int redisMaxIdle) {
		this.redisMaxIdle = redisMaxIdle;
	}

	public int getRedisMaxTotal() {
		return redisMaxTotal;
	}

	public void setRedisMaxTotal(int redisMaxTotal) {
		this.redisMaxTotal = redisMaxTotal;
	}

	public int getRedisMaxWaitMillis() {
		return redisMaxWaitMillis;
	}

	public void setRedisMaxWaitMillis(int redisMaxWaitMillis) {
		this.redisMaxWaitMillis = redisMaxWaitMillis;
	}

	public int getRedisTimeout() {
		return redisTimeout;
	}

	public void setRedisTimeout(int redisTimeout) {
		this.redisTimeout = redisTimeout;
	}

	public boolean getRedisTestOnBorrow() {
		return redisTestOnBorrow;
	}

	public void setRedisTestOnBorrow(boolean redisTestOnBorrow) {
		this.redisTestOnBorrow = redisTestOnBorrow;
	}

	public int getRedisDatabase() {
		return redisDatabase;
	}

	public void setRedisDatabase(int redisDatabase) {
		this.redisDatabase = redisDatabase;
	}

	public int getRedisCacheDatabase() {
		return redisCacheDatabase;
	}

	public void setRedisCacheDatabase(int redisCacheDatabase) {
		this.redisCacheDatabase = redisCacheDatabase;
	}

}
