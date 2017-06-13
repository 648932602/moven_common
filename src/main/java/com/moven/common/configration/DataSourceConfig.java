package com.moven.common.configration;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
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
	/** * mybatis mapper resource 路径 */
	private static String MAPPER_PATH = "*/mapper/*Mapper.xml";
	/** * mybatis 配置路径 */
	private static String MYBATIS_CONFIG = "conf/mybatis/MyBatisConfig.xml";
	/** * mapper 类路径 */
	private static String MAPPER_PACKAGE = "com.moven.isso.mapper";
	
	@Autowired
	private JdbcConfig jdbcConfig;
	
//	@Autowired
//	public DataSourceConfig(JdbcConfig jdbcConfig) {
//		super();
//		this.jdbcConfig = jdbcConfig;
//	}

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

	/**
	 * 创建sqlSessionFactoryBean 实例 并且设置configtion 如驼峰命名.等等 设置mapper 映射路径
	 * 设置datasource数据源
	 * 
	 * @return
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		System.out.println("-----sqlSessionFactoryBean msw-----");
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		/** 添加mapper 扫描路径 */
		PathMatchingResourcePatternResolver mapperPathResolver = new PathMatchingResourcePatternResolver();
		String mapperPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
		sqlSessionFactory.setMapperLocations(mapperPathResolver.getResources(mapperPath));
		/** 设置mybatis configuration 扫描路径 */
		ResourceLoader cofingPathLoader = new DefaultResourceLoader(); 
		String configPath = ResourceLoader.CLASSPATH_URL_PREFIX + MYBATIS_CONFIG;
		sqlSessionFactory.setConfigLocation(cofingPathLoader.getResource(configPath));
		/** 设置datasource */
		sqlSessionFactory.setDataSource(dataSource());
		System.out.println("-----sqlSessionFactoryBean msw-----");
		return sqlSessionFactory;
	}
	
	@Bean
	public static MapperScannerConfigurer createMapperScannerConfigurer(){
		System.out.println("-----mapperScannerConfigurer msw-----");
		MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
		mapperScanner.setBasePackage(MAPPER_PACKAGE);
		mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapperScanner;
	}

}
