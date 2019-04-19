package com.hhf.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {
	
	/**
	 *  Ribbon更改负载均衡算法
	 *  默认 轮询算法
	 * @return
	 */
	@Bean
	public IRule getIRule() {
//		return new RandomRule();   //更改负载均衡算法  用随机算法替代默认的轮询算法
		return new RandomRule_ZY();   //更改负载均衡算法  用自定义算法  用轮询算法 ，每台访问5次
	}
}
