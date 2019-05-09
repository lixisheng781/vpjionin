package com.vpclub.config;


import com.baomidou.mybatisplus.mapper.ISqlInjector;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.boot.starter.ConfigurationCustomizer;
import com.vpclub.mybatis.JsonArrayTypeHandler;
import com.vpclub.mybatis.JsonTypeHandler;
import com.vpclub.mybatis.StringArrayTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MybatisPlusConfig {


	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor interceptor = new PaginationInterceptor();
		interceptor.setLocalPage(true);
		return interceptor;
	}

	@Bean
	public ISqlInjector sqlInjector(){
		return new LogicSqlInjector();
	}
	
	@Bean
	public ConfigurationCustomizer configurationCustomizer() {
		return new MybatisPlusCustomizers();
	}
	
	class MybatisPlusCustomizers implements ConfigurationCustomizer {
		
		@Override
		public void customize(org.apache.ibatis.session.Configuration configuration) {
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			typeHandlerRegistry.register(StringArrayTypeHandler.class);
			//typeHandlerRegistry.register(JsonTypeHandler.class);
			//typeHandlerRegistry.register(JsonArrayTypeHandler.class);
		}
	}

	/**
	 * mybatis-plus SQL执行效率插件【生产环境可以关闭】
	 */
	@Bean
	@Profile("dev")
	public PerformanceInterceptor performanceInterceptor() {
		return new PerformanceInterceptor();
	}
}