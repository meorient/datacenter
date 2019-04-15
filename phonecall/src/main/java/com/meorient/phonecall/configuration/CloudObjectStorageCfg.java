package com.meorient.phonecall.configuration;

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

	/** secretId */
	private String secretId;

	/** secretKey */
	private String secretKey;

	/** region */
	private String region;

	/**
	 * CosClientBean
	 * 
	 * @return
	 */
	@Bean
	public COSClient getCosClient() {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosClient = new COSClient(cred, clientConfig);
		return cosClient;
	}

	/**
	 * @取得 secretId
	 */
	public String getSecretId() {
		return secretId;
	}

	/**
	 * @设置 secretId
	 */
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	/**
	 * @取得 secretKey
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * @设置 secretKey
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * @取得 region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @设置 region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

}
