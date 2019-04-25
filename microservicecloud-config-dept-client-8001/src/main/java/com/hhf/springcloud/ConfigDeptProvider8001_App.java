package com.hhf.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(value = {"com.hhf.springcloud.dao","com.hhf.springcloud.mapper"})
@ImportResource(locations = "classpath:mybatis/mybatis.cfg.xml")   //启动时加载config目录下面的xml配置文件 
@EnableEurekaClient       //本服务启动后会自动注册进eureka服务中(本服务为客户端)
public class ConfigDeptProvider8001_App {

	public static void main(String[] args) {
		SpringApplication.run(ConfigDeptProvider8001_App.class, args);
	}
}
