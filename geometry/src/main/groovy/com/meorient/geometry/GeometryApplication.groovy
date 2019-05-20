package com.meorient.geometry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@SpringBootApplication
@ComponentScan
class GeometryApplication {
	
	/**
	 * 解决跨域请求，注册CORS过滤器
	 * @return
	 */
	@Bean
	CorsFilter getCorsFilter() {
		def cfg = new CorsConfiguration();
		cfg.addAllowedOrigin("*");
		cfg.addAllowedHeader("*");

		def configurationSource = new UrlBasedCorsConfigurationSource();
		configurationSource.registerCorsConfiguration("/**", cfg.applyPermitDefaultValues());
		return new CorsFilter(configurationSource);
	}

	static void main(String[] args) {
		SpringApplication.run(GeometryApplication, args)
	}

}
