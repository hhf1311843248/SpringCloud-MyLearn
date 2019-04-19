package com.hhf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.hhf.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//在启动该服务的时候就能去加载我们自定义的Ribbon负载均衡算法配置类，从而使配置生效
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptCustomer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptCustomer80_App.class, args);
	}
}
