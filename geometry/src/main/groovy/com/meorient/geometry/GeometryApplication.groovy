package com.meorient.geometry

import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

@SpringBootApplication
@RestController
@MapperScan("/")
class GeometryApplication {
	
	@Autowired
	ApplicationContext applicationContext
	
	/**
	 * 查询指定范围内客户
	 * @return
	 */
	@RequestMapping(value="/v1/customers/:location/api",method = RequestMethod.GET)
	String nearby(Customer cust) {
		def mapper = applicationContext.getBean(H2Mapper.class)
		JsonOutput output = new JsonOutput();
		output.toJson(mapper.find(1L))
		// 分别通过mysql，mongo，redis，h2进行地理查询
		// 统计各个查询的响应时间，返回正确结果
		// TODO	
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
