package com.meorient.geometry

import org.h2.util.CurrentTimestamp
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.data.geo.CustomMetric
import org.springframework.data.geo.Distance
import org.springframework.data.geo.GeoResults
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.BasicQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.NearQuery
import org.springframework.data.mongodb.core.query.Query
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Metrics;
import com.alibaba.fastjson.*
import com.mongodb.BasicDBObject
import groovy.json.JsonOutput

@SpringBootApplication
@RestController
@MapperScan("/")
class GeometryApplication {
	
	@Autowired
	ApplicationContext applicationContext
	
	@Autowired
	MongoTemplate mongoTemplate
	
	/**
	 * 查询指定范围内客户
	 * @return
	 */
	@RequestMapping(value="/v1/customers/location/api",method = RequestMethod.GET)
	String nearby(longitude,latitude,distance) {
		// 模拟
		longitude = 120.0
		latitude = 30.0
		distance = 50000
		// 分别通过mysql，mongo，redis，h2进行地理查询

		// 通过h2实现地理位置查询
		def mapper = applicationContext.getBean(H2Mapper.class)
		JsonOutput output = new JsonOutput()
		
		// 通过mongodb实现地理附近查询
		def point = [longitude,latitude]
		BasicDBObject obj = new BasicDBObject("location",new BasicDBObject('$nearSphere',new BasicDBObject('$geometry',
				new BasicDBObject("type","Point").append('coordinates', point)).append('$maxDistance', distance)))
		Query query = new BasicQuery(String.valueOf(obj))
		def list = mongoTemplate.find(query, Customer,"geometry")
        'mongo方式 ---------->' + JSON.toJSONString(list.size())
		// 通过redis实现地理附近查询
		
		// 通过mysql-geo实现地理附近查询
		
		// 统计各个查询的响应时间，返回正确结果
		// TODO	
		return JSON.toJSONString(list)
	}
	
	/**
	 * 添加指定范围内客户
	 * @return
	 */
	@RequestMapping(value="/v1/customers/:location/api",method = RequestMethod.POST)
	String add(longitude,altitude,distance) {
		// 分别调用高德，百度api得到客户具体的经纬度
		// TODO
		// 分别向mysql，mongo，redis，h2添加数据
		// TODO
	}
	public static void main(String[] args) {
		new SpringApplication(GeometryApplication).run(args)
	}
}
