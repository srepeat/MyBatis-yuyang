package com.atguigu.mybatis.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {

	//使用条件id查询对象数据
	public Employee getEmpById(Integer id);
	
	//查询全部
	public List<Employee> getEmps();
	
	//删除
	public void getDeleteById(Integer id);
	
	//修改
	public void getUpdateById(Employee employee);
	
	//新增
	public void getAddEmps(Employee employee);
	
}
