package com.hhf.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hhf.springcloud.entity.Dept;

@Repository
public interface DeptDao {

	public boolean addDept(Dept dept);
	 
	  public Dept findById(Long id);
	 
	  public List<Dept> findAll();

}
