package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.PageHe;

public interface EmployeeMapper {

	//ʹ������id��ѯ��������
	public Employee getEmpById(Integer id);
	
	
	public List<Employee> getEmps();
	
	public Long addEmps(Employee employee);
	
	public void getPageByProcedure(PageHe pageHe);
}
