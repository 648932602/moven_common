package com.moven.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>Title:RedisConfiguration</p>
 * <p>Description:</p>
 * @author moshengwei
 * @date 2017年11月26日 下午5:28:15
 */
@Configuration
public class RedisConfiguration {

    @Autowired
    private CommonProperties commonProperties;

    @Autowired
    public RedisConfiguration(CommonProperties commonProperties) {
        this.commonProperties = commonProperties;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        CommonProperties prop = commonProperties;

        JedisPoolConfig cfg = new JedisPoolConfig();
        cfg.setMaxIdle(prop.getRedisMaxIdle()); // <!--最小空闲连接数 -->
        cfg.setMaxTotal(prop.getRedisMaxTotal()); // <!--最大连接数 -->
        cfg.setMaxWaitMillis(prop.getRedisMaxWaitMillis()); // <!-- 获取连接时的最大等待毫秒数 -->
        cfg.setTestOnBorrow(prop.getRedisTestOnBorrow()); // <!-- 在获取连接的时候检查有效性, 默认false -->

        JedisConnectionFactory connFacotry = new JedisConnectionFactory(cfg);
        connFacotry.setHostName(prop.getRedisHostName());
        connFacotry.setPort(prop.getRedisHostPort());
        connFacotry.setUsePool(true);
        connFacotry.setTimeout(prop.getRedisTimeout());
        connFacotry.setDatabase(prop.getRedisDatabase());
        connFacotry.setPassword(commonProperties.getRedisPassword());//
        return connFacotry;
    }

    @Bean
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate tpl = new StringRedisTemplate(jedisConnectionFactory());
        tpl.setKeySerializer(new StringRedisSerializer());
        tpl.setValueSerializer(new JdkSerializationRedisSerializer());
        tpl.setHashKeySerializer(new StringRedisSerializer());
        tpl.setHashValueSerializer(new JdkSerializationRedisSerializer());
        return tpl;
    }

	@Bean
	public RedisTemplate<String, Object> redisTemplateSupport() {
		RedisTemplate<String, Object> support = new RedisTemplate<String, Object>();
		support.setConnectionFactory(jedisConnectionFactory());
		return support;
	}
}
