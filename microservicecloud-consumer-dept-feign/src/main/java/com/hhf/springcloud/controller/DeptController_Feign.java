package com.hhf.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hhf.springcloud.entity.Dept;
import com.hhf.springcloud.service.DeptClientService;

/**
 * 消费者  不需要service层  只需要消费
 * 通过RestTemplate 来调用rest微服务
 * @author hhf1311843248
 *
 */
@RestController
public class DeptController_Feign {
	
	 @Autowired
	  private DeptClientService service = null;
	 
	  @RequestMapping(value = "/consumer/dept/get/{id}")
	  public Dept get(@PathVariable("id") Long id)
	  {
	   return this.service.get(id);
	  }
	 
	  @RequestMapping(value = "/consumer/dept/list")
	  public List<Dept> list()
	  {
	   return this.service.list();
	  }
	 
	  @RequestMapping(value = "/consumer/dept/add")
	  public Object add(Dept dept)
	  {
	   return this.service.add(dept);
	  }

	
}
