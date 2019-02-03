package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapperPlus {

	//查询id
	public Employee getEmpById(Integer id);
	
	//使用员工id查询部门联表查询
	public Employee getEmpAndDept(Integer id);
	
	public Employee getEmpByIdStep(Integer id);
	
	public List<Employee> getDeptByIdStep(Integer deptId);
	
}
