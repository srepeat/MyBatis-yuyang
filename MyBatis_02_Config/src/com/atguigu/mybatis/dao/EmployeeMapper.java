package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {

	//使用条件id查询对象数据
	public Employee getEmpById(Integer id);
	
}
