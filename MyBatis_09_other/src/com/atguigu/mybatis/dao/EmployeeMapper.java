package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.PageHe;

public interface EmployeeMapper {

	//使用条件id查询对象数据
	public Employee getEmpById(Integer id);
	
	
	public List<Employee> getEmps();
	
	public Long addEmps(Employee employee);
	
	public void getPageByProcedure(PageHe pageHe);
}
