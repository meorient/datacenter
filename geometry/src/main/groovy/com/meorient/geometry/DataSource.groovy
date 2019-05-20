package com.meorient.geometry

import javax.sql.DataSource

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
//@MapperScan(basePackages="/",sqlSessionFactoryRef="sqlSessionFactory")
class MybatisDataSourceConfig {
	
	@Bean("sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}