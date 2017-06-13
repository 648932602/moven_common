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
	
}
