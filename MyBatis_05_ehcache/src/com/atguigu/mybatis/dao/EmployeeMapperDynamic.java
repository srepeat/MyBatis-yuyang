package com.atguigu.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapperDynamic {
	
	//ʹ��������ѯԱ����Ϣ
	public List<Employee> getEmpsByDynamicSql(Employee employee);
	
	//ʹ��trim
	public List<Employee> getEmpsByDynamicTrim(Employee employee);
	
	//��֧����
	public List<Employee> getEmpsByDunamicChoose(Employee employee);
	
	//�������޸�
	public boolean getEmpsByDynamicUpdate(Employee employee);
	
	//ʹ��foreach����
	public List<Employee> getEmpsByDynamicForEach(@Param("ids")List<Integer> ids);
	
	//��������
	public Integer addEmps(@Param("emps")List<Employee> employees);
	
	//���ò���
	 public List<Employee> getEmpsInnesParam(Employee employee);
}
