package com.hhf.springcloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hhf.springcloud.entity.Dept;
import com.hhf.springcloud.service.DeptService;

/**
 * 服务端  供消费端消费
 * @author hhf1311843248
 *
 */
@RestController
public class DeptController {
	
	private final Logger logger = LoggerFactory.getLogger(DeptController.class);
	@Autowired
	DeptService deptService;
	
	@RequestMapping(value = "/dept/add",method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		logger.info("正在调用8003服务......");
		return deptService.add(dept);
	}
	
	@RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		logger.info("正在调用8003服务......");
		return deptService.get(id);
	}
	
	@RequestMapping(value = "/dept/list",method = RequestMethod.GET)
	public List<Dept> list() {
		logger.info("正在调用8003服务......");
		return deptService.list();
	}
}
