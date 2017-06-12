package com.moven.common.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <p>
 * Title:MyBatisConfig
 * </p>
 * <p>
 * Description:MyBatis 配置类
 * </p>
 * 
 * @author moshengwei
 * @date 2017年6月12日 下午6:59:53
 */
@Configuration
@ImportResource(locations = { "classpath*:conf/properties/mybatis.properties" })
public class MyBatisConfig {

	@Bean(name = "dataSource", destroyMethod = "close")
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("${jdbc.driverclassname}");
		dataSource.setUrl("${jdbc.url}");
		dataSource.setUsername("${jdbc.username}");
		dataSource.setPassword("${jdbc.password}");
		// 初始化连接大小
		dataSource.setInitialSize(0);
		// 连接池最大数量
		dataSource.setMaxActive(0);
		// 连接池最大空闲
		// dataSource.setMaxIdle(0);
		// 连接池最小空闲
		dataSource.setMinIdle(0);
		// 获取连接最大等待时间
		dataSource.setMaxWait(0);
		return dataSource;
	}
}
