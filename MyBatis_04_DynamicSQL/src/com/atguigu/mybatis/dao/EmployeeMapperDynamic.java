package com.atguigu.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapperDynamic {
	
	//使用条件查询员工信息
	public List<Employee> getEmpsByDynamicSql(Employee employee);
	
	//使用trim
	public List<Employee> getEmpsByDynamicTrim(Employee employee);
	
	//分支测试
	public List<Employee> getEmpsByDunamicChoose(Employee employee);
	
	//按条件修改
	public boolean getEmpsByDynamicUpdate(Employee employee);
	
	//使用foreach遍历
	public List<Employee> getEmpsByDynamicForEach(@Param("ids")List<Integer> ids);
	
	//批量更新
	public Integer addEmps(@Param("emps")List<Employee> employees);
	
	//内置参数
	 public List<Employee> getEmpsInnesParam(Employee employee);
}
