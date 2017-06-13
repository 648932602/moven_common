package com.moven.common.configration;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * <p>
 * Title:SqlSessionFactoryConfig
 * </p>
 * <p>
 * Description:会话工厂类
 * </p>
 * 
 * @author moshengwei
 * @date 2017年6月12日 下午9:47:59
 */
@Configuration
public class SqlSessionFactoryConfig {
	/** * mybatis 配置路径 */
	private static String MYBATIS_CONFIG = "*/mapper/*Mapper.xml";
	/** * mybatis mapper resource 路径 */
	private static String MAPPER_PATH = "conf/mybatis/MyBatisConfig.xml";

	@Autowired
	private DataSource dataSource;

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
		/** 设置mybatis configuration 扫描路径 */
		sqlSessionFactory.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
		/** 添加mapper 扫描路径 */
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
		sqlSessionFactory.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
		/** 设置datasource */
		sqlSessionFactory.setDataSource(dataSource);
		System.out.println("-----sqlSessionFactoryBean msw-----");
		return sqlSessionFactory;
	}
}
