package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {

	//ʹ������id��ѯ��������
	public Employee getEmpById(Integer id);
	
}