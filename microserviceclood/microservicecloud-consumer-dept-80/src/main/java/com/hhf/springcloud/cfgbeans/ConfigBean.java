package com.hhf.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced    //开启Ribbon负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	/**
	 *  Ribbon更改负载均衡算法
	 *  默认 轮询算法
	 * @return
	 */
//	@Bean
	public IRule getIRule() {
		return new RandomRule();   //更改负载均衡算法  用随机算法替代默认的轮询算法
	}
}
