package com.hhf.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hhf.springcloud.entity.Dept;
public interface DeptService {
	
	  public boolean add(Dept dept);
	  public Dept   get(Long id);
	  public List<Dept> list();
}
