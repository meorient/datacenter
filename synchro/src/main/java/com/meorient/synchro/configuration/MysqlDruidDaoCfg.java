package com.meorient.synchro.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.meorient.common.database.mysql.AbsBaseDruidDaoCfg;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年3月19日上午10:34:21
 */
@Configuration
@Order(2)
@ConfigurationProperties(prefix = "masterDB.dbCfg")
public class MysqlDruidDaoCfg extends AbsBaseDruidDaoCfg {
	/**
	 * 得到数据源
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	@Primary
	@Bean(name = "masterDBDataSource", initMethod = "init", destroyMethod = "close")
	@Qualifier("masterDBDataSource")
	public DataSource getDataSource() throws Exception {
		return super.generateDataSource();
	}



	/**
	 * 得到单条sql语句操作模板
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Override
	@Primary
	@Bean(name = "masterDBSqlSessionTemplate")
	public SqlSessionTemplate getSqlSessionTemplate(
			@Qualifier("masterDBSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * 得到批量sql操作模板
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Override
	@Primary
	@Bean(name = "masterDBSqlSessionBatchTemplate")
	public SqlSessionTemplate getSqlSessionBatchTemplate(
			@Qualifier("masterDBSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionBatchTemplate(sqlSessionFactory);
	}

	/**
	 * 事务管理
	 * 
	 * @param dataSource
	 * @return
	 */
	@Override
	@Primary
	@Bean(name = "masterDBTxManager")
	public PlatformTransactionManager getTransactionManager(@Qualifier("masterDBDataSource") DataSource dataSource) {
		return super.generateTransactionManager(dataSource);
	}
	
	/**
	 * 创建mybatis SqlSessionFactory
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Override
	@Primary
	@Bean(name = "masterDBSqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("masterDBDataSource") DataSource dataSource)
			throws Exception {
		return super.generateSqlSessionFactory(dataSource);
	}

	/**
	 * 事务用在哪些方法拦截器
	 * 
	 * @param txManager
	 * @return
	 */
	@Override
	@Primary
	@Bean(name = "masterDBTxInterceptor")
	public TransactionInterceptor getTransactionInterceptor(
			@Qualifier("masterDBTxManager") PlatformTransactionManager txManager) {
		return super.generateTransactionInterceptor(txManager);
	}

	/**
	 * 事务用在哪些类上
	 * 
	 * @param interceptor
	 * @return
	 */
	@Override
	@Primary
	@Bean(name = "masterDBTxAop")
	public DefaultPointcutAdvisor getTransactionDefaultPointcutAdvisor(
			@Qualifier("masterDBTxInterceptor") TransactionInterceptor interceptor) {
		return super.generateTransactionDefaultPointcutAdvisor(interceptor);
	}

}