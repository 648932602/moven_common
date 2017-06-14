package com.moven.common.configration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.moven.common.prop.JdbcConfig;

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

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		System.out.println("-----dataSource msw-----");
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(jdbcConfig.getDriverClass());
		dataSource.setUrl(jdbcConfig.getUrl());
		dataSource.setUsername(jdbcConfig.getUsername());
		dataSource.setPassword(jdbcConfig.getPassword());
		// 初始化连接大小
		dataSource.setInitialSize(jdbcConfig.getInitialSize());
		// 连接池最大数量
		dataSource.setMaxActive(jdbcConfig.getMaxActive());
		// 连接池最大空闲
		dataSource.setMaxIdle(jdbcConfig.getMaxIdle());
		// 连接池最小空闲
		dataSource.setMinIdle(jdbcConfig.getMinIdle());
		// 获取连接最大等待时间
		dataSource.setMaxWait(jdbcConfig.getMaxWait());
		System.out.println("-----dataSource msw-----");
		return dataSource;
	}

}
