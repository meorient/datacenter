package com.meorient.geometry

import org.bson.types.BasicBSONList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.aggregation.GeoNearOperation
import org.springframework.data.mongodb.core.query.BasicQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.NearQuery
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.geo.Metrics

import com.alibaba.fastjson.*
import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.mongodb.client.AggregateIterable

@RestController
class GeoController {
	
	@Autowired
	ApplicationContext applicationContext
	
	@Autowired
	MongoTemplate mongoTemplate
	
	@Autowired
	RedisTemplate redisTemplate;
	
	
	@RequestMapping("/test")
	String test() {
		'test'.getBytes()
	}
	
	
	/**
	 * 查询指定范围内客户
	 * @return
	 */
	@RequestMapping(value="/v1/customers/location/api",method = RequestMethod.GET)
	String nearby(Double longitude,Double latitude,Integer distance,String keyword,Integer limit) {
		// 默认值
		longitude = longitude ?: 120.377559
		latitude = latitude ?: 30.309529
		distance = distance ?: 1000
		limit = limit ?: 5
		keyword = keyword ?: ''
		// 通过h2实现地理位置查询
		//def mapper = applicationContext.getBean(H2Mapper.class)
		//def list = mapper.find(1L)
		
		// 通过mongodb实现地理附近查询
		def location = new Point(longitude , latitude);
		def query = NearQuery.near(location).maxDistance(new Distance(distance, Metrics.MILES)).num(limit).spherical(true)
		.distanceMultiplier(6378137).query(new Query(Criteria.where("name").regex(".*"+keyword+".*")))
		def operation = new GeoNearOperation(query , "distance")
		def aggregation = new Aggregation(operation)
		def results = mongoTemplate.aggregate(aggregation,"geometry",Customer)
		
//		AggregationResults results = mongoTemplate.aggregate(queryUnwind, Customer,'geometry');
		
		// 通过redis实现地理附近查询
//		GeoOperations<String,String> ops = redisTemplate.opsForGeo()
//		ops.add('customers', new GeoLocation(cust.name,new Point(cust.longitude,cust.latitude)))
//		List<Point> points = ops.position('customers', cust.name)
//		def center = new Point(longitude,latitude)
//		def circle = new Circle(center, 50000)
//		GeoResults georesults = ops.radius('customers', circle , RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().sortAscending())
//		JSON.toJSONString(georesults)
		// 统计各个查询的响应时间，返回正确结果
		// TODO
		def cust = new Customer()
		cust.longitude = longitude
		cust.latitude = latitude
		cust.distance = distance
		cust.limit = limit
		cust.keyword = keyword
		cust.details = results.getMappedResults()
		return JSON.toJSONString(cust)
	} 
}
