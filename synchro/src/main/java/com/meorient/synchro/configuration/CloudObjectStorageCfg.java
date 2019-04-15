package com.meorient.synchro.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;

/**
 * @功能: 腾讯云COS配置类
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月27日上午10:19:53
 */
@Configuration
@ConfigurationProperties(prefix = "cloud.cos")
public class CloudObjectStorageCfg {
	
	/**
	 * 得到COS-Client
	 */
	@Bean
	public static COSClient getCosClient() {
		COSCredentials cred = new BasicCOSCredentials("AKIDY0iJBWlaL5veEzsDYe7rV2dgffHlAeUD", "padvoSeBgKCwhmjeHl5H9uZMWZZai3LB");
		ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
		COSClient cosClient = new COSClient(cred, clientConfig);
		return cosClient;
	}
}
