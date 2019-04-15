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
 * @日期:2019年3月19日上午10:34:21
 */
@Configuration
@Order(1)
@ConfigurationProperties(prefix = "masterDB.netsuite")
public class NetsuiteDruidDaoCfg extends AbsBaseDruidDaoCfg {
	/**
	 * 得到数据源
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	@Bean(name = "nsDataSource", initMethod = "init", destroyMethod = "close")
	@Qualifier("nsDataSource")
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
	@Bean(name = "nsSqlSessionTemplate")
	@Qualifier("nsSqlSessionTemplate")
	public SqlSessionTemplate getSqlSessionTemplate(
			@Qualifier("nsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * 得到批量sql操作模板
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Override
	@Bean(name = "nsSqlSessionBatchTemplate")
	@Qualifier("nsSqlSessionBatchTemplate")
	public SqlSessionTemplate getSqlSessionBatchTemplate(
			@Qualifier("nsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionBatchTemplate(sqlSessionFactory);
	}

	/**
	 * 创建mybatis SqlSessionFactory
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Override
	@Bean(name = "nsSqlSessionFactory")
	@Qualifier("nsSqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("nsDataSource") DataSource dataSource)
			throws Exception {
		return super.generateSqlSessionFactory(dataSource);
	}



	/**
	 * @方法重写
	 */ 
	@Override
	public PlatformTransactionManager getTransactionManager(DataSource dataSource) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @方法重写
	 */ 
	@Override
	public TransactionInterceptor getTransactionInterceptor(PlatformTransactionManager txManager) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @方法重写
	 */ 
	@Override
	public DefaultPointcutAdvisor getTransactionDefaultPointcutAdvisor(TransactionInterceptor interceptor) {
		// TODO Auto-generated method stub
		return null;
	}
}