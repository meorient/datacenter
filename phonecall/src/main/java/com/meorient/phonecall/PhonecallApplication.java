package com.meorient.phonecall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.meorient.common.converter.DateConvert;
import com.meorient.common.converter.SqlDateConvert;
import com.meorient.common.converter.TimestampConvert;
import com.meorient.common.util.JsonTool;
import com.meorient.phonecall.configuration.CheckOptInterceptor;


@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.meorient" })
public class PhonecallApplication extends WebMvcConfigurerAdapter{
	/** 访问限制拦截器 */
	@Autowired
	CheckOptInterceptor checkOptInterceptor;

	/**
	 * 方法重写:添加访问限制拦截器
	 * 
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(checkOptInterceptor).excludePathPatterns("/page/**");
		super.addInterceptors(registry);
	}

	/**
	 * 解决跨域请求，注册CORS过滤器
	 * 
	 * @return
	 */
	@Bean
	public CorsFilter getCorsFilter() {
		CorsConfiguration cfg = new CorsConfiguration();
		cfg.addAllowedOrigin("*");// 允许跨域访问的域名
		cfg.addAllowedHeader("*");// 请求头

		UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		configurationSource.registerCorsConfiguration("/**", cfg.applyPermitDefaultValues());
		return new CorsFilter(configurationSource);
	}

	/**
	 * 方法重写:替换response返回json格式工具
	 * 
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		JsonTool.addConverter(converters);
		super.configureMessageConverters(converters);
	}

	/**
	 * 方法重写:替换日期格式转换
	 * 
	 * @param registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new DateConvert());
		registry.addConverter(new SqlDateConvert());
		registry.addConverter(new TimestampConvert());
		super.addFormatters(registry);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(PhonecallApplication.class).web(true).run(args);
	}
}
