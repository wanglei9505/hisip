package com.shine.hisip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
@Configuration
@SpringBootApplication
@ComponentScan(basePackages={"com.shine.hisip"})
//增加支持定时任务的注解
//@EnableScheduling
public class HisipApplication {
	private final static Logger logger = LoggerFactory.getLogger(HisipApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HisipApplication.class, args);
	}

	@Bean
	Filter characterEncodingFilter() {
		logger.info("==========初始化编码过滤器=================");
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
}
