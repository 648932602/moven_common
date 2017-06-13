package com.moven.common.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title:JdbcConfig
 * </p>
 * <p>
 * Description:数据库连接配置信息
 * </p>
 * 
 * @author moshengwei
 * @date 2017年6月12日 下午9:43:31
 */
@Configuration
//@PropertySource(value = {"classpath:conf/properties/mybatis.properties"})
public class JdbcConfig {
	/** * 驱动名称 */
	@Value("${jdbc.driverclassname}")
	private String driverClass;
	/** * 数据库连接url */
	@Value("${jdbc.url}")
	private String url;
	/** * 数据库用户名 */
	@Value("${jdbc.username}")
	private String username;
	/** * 数据库密码 */
	@Value("${jdbc.password}")
	private String password;
	/** * 初始化连接数 */
	@Value("${jdbc.initialSize}")
	private int initialSize;
	/** * 最大连接数 */
	@Value("${jdbc.maxActive}")
	private int maxActive;
	/** * 最大空闲 */
	@Value("${jdbc.maxIdle}")
	private int maxIdle;
	/** * 最小空闲 */
	@Value("${jdbc.minIdle}")
	private int minIdle;
	/** * 最大等待时间 */
	@Value("${jdbc.maxWait}")
	private int maxWait;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
}