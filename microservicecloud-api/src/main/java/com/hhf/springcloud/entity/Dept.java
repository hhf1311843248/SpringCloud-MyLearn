package com.hhf.springcloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true) //链式风格访问   dept.setDb_source("dddd").setDeptno(2L);
public class Dept implements Serializable{  //必须序列化
	
	 private Long  deptno;   //主键
	 private String  dname;   //部门名称
	 private String  db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	 
}
