package com.atguigu.mybatis.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {

	//ʹ������id��ѯ��������
	public Employee getEmpById(Integer id);
	
	//��ѯȫ��
	public List<Employee> getEmps();
	
	//ɾ��
	public void getDeleteById(Integer id);
	
	//�޸�
	public void getUpdateById(Employee employee);
	
	//����
	public void getAddEmps(Employee employee);
	
}
