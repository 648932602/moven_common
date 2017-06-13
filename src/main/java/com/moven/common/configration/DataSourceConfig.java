package com.moven.common.configration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <p>
 * Title:MyBatisConfig
 * </p>
 * <p>
 * DataSourceConfig 配置类
 * </p>
 * 
 * @author moshengwei
 * @date 2017年6月12日 下午6:59:53
 */
@Configuration
public class DataSourceConfig {
	@Autowired
	private JdbcConfig jdbcConfig;

	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(jdbcConfig.driverClass);
		dataSource.setUrl(jdbcConfig.url);
		dataSource.setUsername(jdbcConfig.username);
		dataSource.setPassword(jdbcConfig.password);
		// 初始化连接大小
		dataSource.setInitialSize(jdbcConfig.initialSize);
		// 连接池最大数量
		dataSource.setMaxActive(jdbcConfig.maxActive);
		// 连接池最大空闲
		dataSource.setMaxIdle(jdbcConfig.maxIdle);
		// 连接池最小空闲
		dataSource.setMinIdle(jdbcConfig.minIdle);
		// 获取连接最大等待时间
		dataSource.setMaxWait(jdbcConfig.maxWait);
		return dataSource;
	}

	/**
	 * <p>Title:JdbcConfig</p>
	 * <p>Description:数据库连接配置信息</p>
	 * @author moshengwei
	 * @date 2017年6月12日 下午9:43:31
	 */
	@PropertySource(value = "classpath*:conf/properties/mybatis.properties")
	@Component
	static class JdbcConfig {
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
}
