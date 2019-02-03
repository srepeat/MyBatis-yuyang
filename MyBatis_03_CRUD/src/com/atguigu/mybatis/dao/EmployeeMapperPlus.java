package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapperPlus {

	//��ѯid
	public Employee getEmpById(Integer id);
	
	//ʹ��Ա��id��ѯ���������ѯ
	public Employee getEmpAndDept(Integer id);
	
	public Employee getEmpByIdStep(Integer id);
	
	public List<Employee> getDeptByIdStep(Integer deptId);
	
}
