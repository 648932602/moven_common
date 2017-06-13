package com.moven.common.configration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>Title:RootConfig</p>
 * <p>Description:根</p>
 * @author moshengwei
 * @date 2017年6月13日 下午5:07:49
 */

@Configuration
@Import({
	DataSourceConfig.class,
	SqlSessionFactoryConfig.class
})
public class RootConfig {

}
