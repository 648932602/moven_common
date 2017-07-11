package com.moven.common.configration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.moven.common.prop.JdbcConfig;

/**
 * <p>Title:RootConfig</p>
 * <p>Description:根配置文件</p>
 * @author moshengwei
 * @date 2017年6月13日 下午5:07:49
 */

@Configuration
@Import({
	JdbcConfig.class,
	DataSourceConfig.class,
	SqlSessionFactoryConfig.class
})
@ImportResource({
//    "classpath:com/moven/sso/dubbo-provider.xml",
    "classpath:com/moven/sso/dubbo-reference.xml"
})
public class RootConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		placeholderConfigurer.setLocations(new ClassPathResource("conf/properties/mybatis.properties"));
		return placeholderConfigurer;
	}
}
