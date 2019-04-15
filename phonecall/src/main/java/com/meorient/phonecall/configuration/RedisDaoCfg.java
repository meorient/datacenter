/** */
package com.meorient.phonecall.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.meorient.common.database.redis.AbsBaseRedisCfg;
import com.meorient.common.database.redis.BaseRedisDao;

/**
 * @功能:
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年3月19日上午10:34:21
 */
@Configuration
@ConfigurationProperties(prefix = "masterDB.redisCfg")
public class RedisDaoCfg extends AbsBaseRedisCfg {
	/**
	 * 得到db=0的RedisDao
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	@Bean(name = "baseRedisDaoDef")
	public BaseRedisDao getBaseRedisDao() throws Exception {
		return this.generateBaseRedisDao(0);
	}
}
