package com.hhf.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hhf.springcloud.entity.Dept;

/**
 * 消费者  不需要service层  只需要消费
 * 通过RestTemplate 来调用rest微服务
 * @author hhf1311843248
 *
 */
@RestController
public class DeptController_Consumer {
	
//	private final String REST_URL = "http://127.0.0.1:8001";
	
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	/**
	 * 	使用restTemplate访问restful接口非常的简单粗暴无脑。
		(url, requestMap, ResponseBean.class)这三个参数分别代表 
		REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 消费者 添加部门
	 * @param dept
	 * @return
	 */
	@RequestMapping(value = "/customer/dept/add")
	public boolean add(Dept dept) {		
		return restTemplate.postForObject(REST_URL_PREFIX+"dept/add", dept, Boolean.class);
		
	}
	/**
	 * 消费者 通过id查询操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/customer/dept/get/{id}",method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	/**
	 * 查询所有部门
	 * @return
	 */
	@RequestMapping(value = "/customer/dept/list",method = RequestMethod.GET)
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	
}
