package com.moven.common.configration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * <p>
 * Title:RootConfig
 * </p>
 * <p>
 * Description:根配置文件，等价于 applicationContext.xml
 * </p>
 * 
 * @author moshengwei
 * @date 2017年6月12日 下午10:12:25
 */
@Configuration
@ComponentScan(basePackages = "com.moven")
@EnableWebMvc
public class WebMvnConfig extends WebMvcConfigurerAdapter {
	/**
	 * 返回信息转换器配置
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		System.out.println("-----messageConverters msw-----");
		// 配置Fastjson支持
		FastJsonHttpMessageConverter jsonConverter = new FastJsonHttpMessageConverter();
		List<MediaType> jsonTypes = new ArrayList<MediaType>(2);
		jsonTypes.add(MediaType.TEXT_HTML);
		jsonTypes.add(MediaType.APPLICATION_JSON_UTF8);
		jsonConverter.setSupportedMediaTypes(jsonTypes);
		List<SerializerFeature> jsonFeatures = new ArrayList<SerializerFeature>(9);
		jsonFeatures.add(SerializerFeature.QuoteFieldNames);
		jsonFeatures.add(SerializerFeature.WriteMapNullValue);
		jsonFeatures.add(SerializerFeature.WriteNullNumberAsZero);
		jsonFeatures.add(SerializerFeature.WriteNullListAsEmpty);
		jsonFeatures.add(SerializerFeature.WriteNullStringAsEmpty);
		jsonFeatures.add(SerializerFeature.WriteNullBooleanAsFalse);
		jsonFeatures.add(SerializerFeature.WriteNullStringAsEmpty);
		jsonFeatures.add(SerializerFeature.WriteMapNullValue);
		// jsonFeatures.add(SerializerFeature.WriteDateUseDateFormat);
		System.out.println("-----messageConverters msw-----");
		super.configureMessageConverters(converters);
	}

}
