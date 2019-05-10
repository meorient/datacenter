package com.meorient.geometry

import javax.sql.DataSource
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
 
@Configuration
@MapperScan(basePackages="/",sqlSessionFactoryRef="sqlSessionFactory")
class MybatisDataSourceConfig {
 
	//此处使用自动装配的H2数据源,可自定义数据源
	@Bean("sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory(DataSource dataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}