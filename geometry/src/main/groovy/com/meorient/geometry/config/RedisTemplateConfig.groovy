package com.meorient.geometry.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

@Configuration
class RedisTemplateConfig {
	
		@Autowired
		RedisTemplate redisTemplate;
	
		@Bean
		<T> RedisTemplate<String, T> redisTemplateKeyString(RedisConnectionFactory redisConnectionFactory) {
			redisTemplate.setConnectionFactory(redisConnectionFactory);
			def jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
			def objectMapper = new ObjectMapper();
			objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
			objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
			redisTemplate.setKeySerializer(new StringRedisSerializer());
			redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
			redisTemplate.afterPropertiesSet();
			return redisTemplate;
		}
		
		/**配置其他类型的redisTemplate***/
		@Bean
		RedisTemplate<Object, Object> redisTemplateKeyObject(RedisConnectionFactory redisConnectionFactory) {
			redisTemplate.setConnectionFactory(redisConnectionFactory);
			Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
			objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
			redisTemplate.setKeySerializer(new StringRedisSerializer());
			redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
			redisTemplate.afterPropertiesSet();
			return redisTemplate;
		}
}
