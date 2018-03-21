package com.itheima.springbootProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@SpringBootApplication
//@MapperScan(basePackages="com.itheima.springbootProject.mapper" )
@EnableCaching//开启缓存
//
public class SpringbootProjectApplication   extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
}
	@Bean
	public MapperScannerConfigurer createMapperScanner(){
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("com.itheima.springbootProject.mapper");
		Properties properties = new Properties();
		properties.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
		configurer.setProperties(properties);
		return configurer;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootProjectApplication.class);
	}
}
