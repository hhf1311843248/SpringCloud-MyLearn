package com.hhf.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hhf.springcloud.dao.DeptDao;
import com.hhf.springcloud.entity.Dept;
import com.hhf.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService service = null;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	//一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法。
	@HystrixCommand(fallbackMethod = "processHystrix_Get") 
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = this.service.get(id);
		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
}
