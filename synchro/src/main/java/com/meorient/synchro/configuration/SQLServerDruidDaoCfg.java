package com.meorient.synchro.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.meorient.common.database.mysql.AbsBaseDruidDaoCfg;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年3月19日下午1:34:34
 */
@Configuration
@Order(3)
@ConfigurationProperties(prefix = "masterDB.dynamics")
public class SQLServerDruidDaoCfg extends AbsBaseDruidDaoCfg {
	/**
	 * 得到数据源
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	@Bean(name = "sqlserverDatasource", initMethod = "init", destroyMethod = "close")
	@Qualifier("sqlserverDatasource")
	public DataSource getDataSource() throws Exception {
		return super.generateDataSource();
	}

	/**
	 * 创建mybatis SqlSessionFactory
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Override
	@Bean(name = "sqlserverSqlSessionFactory")
	@Qualifier("sqlserverSqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("sqlserverDatasource")DataSource dataSource)
			throws Exception {
		return super.generateSqlSessionFactory(dataSource);
	}
	
	/**
	 * 事务管理
	 * 
	 * @param dataSource
	 * @return
	 */
	@Override
	@Bean(name = "sqlserverTxManager")
	@Qualifier("sqlserverTxManager")
	public PlatformTransactionManager getTransactionManager(@Qualifier("sqlserverDatasource")DataSource dataSource) {
		return super.generateTransactionManager(dataSource);
	}

	/**
	 * 得到单条sql语句操作模板
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Override
	@Bean(name = "sqlserverSqlSessionTemplate")
	@Qualifier("sqlserverSqlSessionTemplate")
	public SqlSessionTemplate getSqlSessionTemplate(
			@Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * 得到批量sql操作模板
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Override
	@Bean(name = "sqlserverSqlSessionBatchTemplate")
	@Qualifier("sqlserverSqlSessionBatchTemplate")
	public SqlSessionTemplate getSqlSessionBatchTemplate(
			@Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionBatchTemplate(sqlSessionFactory);
	}

	/**
	 * 事务用在哪些方法拦截器
	 * 
	 * @param txManager
	 * @return
	 */
	@Override
	@Bean(name = "sqlserverTxInterceptor")
	@Qualifier("sqlserverTxInterceptor")
	public TransactionInterceptor getTransactionInterceptor(
			@Qualifier("sqlserverTxManager") PlatformTransactionManager txManager) {
		return super.generateTransactionInterceptor(txManager);
	}

	/**
	 * 事务用在哪些类上
	 * 
	 * @param interceptor
	 * @return
	 */
	@Override
	@Bean(name = "sqlserverTxAop")
	@Qualifier("sqlserverTxAop")
	public DefaultPointcutAdvisor getTransactionDefaultPointcutAdvisor(
			@Qualifier("sqlserverTxInterceptor") TransactionInterceptor interceptor) {
		return super.generateTransactionDefaultPointcutAdvisor(interceptor);
	}
}